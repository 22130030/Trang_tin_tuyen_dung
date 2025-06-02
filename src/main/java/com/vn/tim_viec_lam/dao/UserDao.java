package com.vn.tim_viec_lam.dao;


import com.vn.tim_viec_lam.dao.model.Job;
import com.vn.tim_viec_lam.dao.model.User;
import com.vn.tim_viec_lam.database.DBconnect;


import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class UserDao {
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users u JOIN roles r ON r.userID = u.userID";

        try (
                Connection con = DBconnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                User u = excute(rs);
                users.add(u);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users;
    }
    public User getUserByEmail(String email) {
        String sql = "SELECT * FROM users u " +
                "JOIN roles r ON r.userID = u.userID " +
                "WHERE u.email = ?";
        try (
                Connection con = DBconnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return excute(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Lỗi khi truy vấn user theo email", e);
        }
        return null;
    }
    public User excute(ResultSet rs) throws SQLException {
        int id = rs.getInt("userID");
        String email = rs.getString("email");
        int role = rs.getInt("roleNum");
//        String password = rs.getString("password");
        String name = rs.getString("name");
        String phoneNumber = rs.getString("phone_number");
        int status = rs.getInt("status");
        LocalDateTime date = rs.getTimestamp("created_at").toLocalDateTime();
        String image = rs.getString("image");
        return new User(id,email,"",name,phoneNumber,status,date,role,image);
    }
    public List<User> getListUser() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT u.*, r.roleNum, ua.password, ua.provider_id " +
                "FROM users u " +
                "JOIN user_auth ua ON ua.userID = u.userID " +
                "JOIN roles r ON r.userID = u.userID";

        try (
                Connection conn = DBconnect.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                User user = getResultSet(rs); // Phương thức này bạn đã định nghĩa sẵn
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Lỗi khi lấy danh sách người dùng", e);
        }
    }
    public List<User> findListUserbyEmail(String email) {
        List<User> users = new ArrayList<>();
        String sql = "SELECT u.*, r.roleNum, ua.password, ua.provider_id " +
                "FROM users u " +
                "JOIN roles r ON u.userID = r.userID " +
                "JOIN user_auth ua ON ua.userID = u.userID " +
                "WHERE u.email LIKE ?";

        try (
                Connection conn = DBconnect.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, "%" + email + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = getResultSet(rs);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Lỗi khi tìm danh sách user theo email", e);
        }
        return users;
    }
    public User findListUserbyID(int id) {
        String sql = "SELECT u.*, r.roleNum, ua.password, ua.provider_id " +
                "FROM users u " +
                "JOIN roles r ON u.userID = r.userID " +
                "JOIN user_auth ua ON ua.userID = u.userID " +
                "WHERE u.userID = ?";

        try (
                Connection conn = DBconnect.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return getResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Lỗi khi tìm user theo ID", e);
        }
        return null;
    }
    public boolean deleteUser(int userId) {
        String deleteRolesSQL = "DELETE FROM roles WHERE userID = ?";
        String deleteUserAuthSQL = "DELETE FROM user_auth WHERE userID = ?";
        String deleteUserSQL = "DELETE FROM users WHERE userID = ?";

        try (
                Connection conn = DBconnect.getConnection();
                PreparedStatement deleteRolesStmt = conn.prepareStatement(deleteRolesSQL);
                PreparedStatement deleteUserAuthStmt = conn.prepareStatement(deleteUserAuthSQL);
                PreparedStatement deleteUserStmt = conn.prepareStatement(deleteUserSQL)
        ) {
            // Xóa roles
            deleteRolesStmt.setInt(1, userId);
            deleteRolesStmt.executeUpdate();

            // Xóa user_auth
            deleteUserAuthStmt.setInt(1, userId);
            deleteUserAuthStmt.executeUpdate();

            // Xóa users
            deleteUserStmt.setInt(1, userId);
            int rowsAffected = deleteUserStmt.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Lỗi khi xóa user", e);
        }
    }
    public boolean updateUser(int id, String email, String pass, int role, int status, String image) {
        String updateUserSQL = "UPDATE users SET email = ?, status = ?, image = ? WHERE userID = ?";
        String updateRoleSQL = "UPDATE roles SET roleNum = ? WHERE userID = ?";
        String updatePassSQL = "UPDATE user_auth SET password = ? WHERE userID = ?";

        try (Connection conn = DBconnect.getConnection()) {
            conn.setAutoCommit(false); // Bắt đầu transaction

            // Cập nhật bảng users
            try (PreparedStatement userStmt = conn.prepareStatement(updateUserSQL)) {
                userStmt.setString(1, email);
                userStmt.setInt(2, status);
                userStmt.setString(3, image);
                userStmt.setInt(4, id);
                userStmt.executeUpdate();
            }

            // Cập nhật bảng roles
            try (PreparedStatement roleStmt = conn.prepareStatement(updateRoleSQL)) {
                roleStmt.setInt(1, role);
                roleStmt.setInt(2, id);
                roleStmt.executeUpdate();
            }

            // Cập nhật bảng user_auth
            try (PreparedStatement passStmt = conn.prepareStatement(updatePassSQL)) {
                passStmt.setString(1, pass);
                passStmt.setInt(2, id);
                passStmt.executeUpdate();
            }

            conn.commit(); // Thành công thì commit
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public User getResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        int id = rs.getInt("userID");
        String email = rs.getString("email");
        String password = rs.getString("password");
        String phone = rs.getString("phone_number");
        int status = rs.getInt("status");
        LocalDateTime created = rs.getTimestamp("created_at").toLocalDateTime();
        int roleNum = rs.getInt("roleNum");
        String provider_id = rs.getString("provider_id");
        String image = rs.getString("image");
        user = new User(id, email, password, status,phone, created,provider_id,image);
        user.setRoleNum(roleNum);
        return user;
    }
    public boolean insertUser(String email, String pass, String fullName, String phone, String auth_provider, String provider_id) {
        String sql = "insert into users(email,phone_number,status,created_at,name) values(?,?,1,NOW(),?)";
        try (Connection con = DBconnect.getConnection();
             PreparedStatement prep = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            con.setAutoCommit(false); // bắt đầu transaction

            prep.setString(1, email);
            prep.setString(2, phone);
            prep.setString(3, fullName);
            int rowsAffected = prep.executeUpdate();

            if (rowsAffected > 0) {
                try (ResultSet rs = prep.getGeneratedKeys()) {
                    if (rs.next()) {
                        int userID = rs.getInt(1);

                        // insert roles
                        String sqlRoles = "insert into roles(userID,roleNum) values(?,?)";
                        try (PreparedStatement prepRoles = con.prepareStatement(sqlRoles)) {
                            prepRoles.setInt(1, userID);
                            prepRoles.setInt(2, 1);
                            prepRoles.executeUpdate();
                        }

                        // insert candidates
                        String sqlCandidates = "insert into candidates(userID,fullName,email,phone) values(?,?,?,?)";
                        try (PreparedStatement prepCandidates = con.prepareStatement(sqlCandidates)) {
                            prepCandidates.setInt(1, userID);
                            prepCandidates.setString(2, fullName);
                            prepCandidates.setString(3, email);
                            prepCandidates.setString(4, phone);
                            prepCandidates.executeUpdate();
                        }

                        // insert user_auth
                        String sqlAuth = "insert into user_auth(userID,auth_provider,provider_id,password,created_at) values(?,?,?,?,NOW())";
                        try (PreparedStatement prepAuth = con.prepareStatement(sqlAuth)) {
                            prepAuth.setInt(1, userID);
                            prepAuth.setString(2, auth_provider);
                            prepAuth.setString(3, provider_id);
                            prepAuth.setString(4, pass);
                            prepAuth.executeUpdate();
                        }
                        con.commit();  // commit transaction
                        return true;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // rollback nếu lỗi xảy ra
            try (Connection con = DBconnect.getConnection()) {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public boolean isEmailExists(String email) {
        String query = "SELECT COUNT(*) FROM users WHERE email = ?";
        try (Connection conn = DBconnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, email.trim().toLowerCase());
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean setStatus(int userID, int status) {
        String sql = "UPDATE users SET status = ? WHERE userID = ?";
        try (Connection con = DBconnect.getConnection();
             PreparedStatement pre = con.prepareStatement(sql)) {
            pre.setInt(1, status);
            pre.setInt(2, userID);
            int res = pre.executeUpdate();
            return res > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getPasswordByEmail(String email) {
        String sql = "SELECT ua.password FROM user_auth ua " +
                "JOIN users u ON ua.userID = u.userID " +
                "WHERE u.email = ? AND ua.auth_provider = 'local'";
        try (Connection connection = DBconnect.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("password");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error retrieving password for email: " + email, e);
        }
        return null; // Nếu không tìm thấy mật khẩu
    }
    public boolean NewPasswordByEmail(String email, String newPassword) {
        Connection connection = DBconnect.getConnection();
        String sql = "UPDATE user_auth ua " +
                "JOIN users u ON ua.userID = u.userID " +
                "SET ua.password = ? " +
                "WHERE u.email = ? AND ua.auth_provider = 'local'";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, newPassword);
            stmt.setString(2, email);
            int rowsUpdated = stmt.executeUpdate();

            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error updating password for email: " + email, e);
        }
    }
    public boolean updatePasswordByEmail(String email, String newPassword) {
        String sql = "UPDATE user_auth ua " +
                "JOIN users u ON ua.userID = u.userID " +
                "SET ua.password = ? " +
                "WHERE u.email = ? AND ua.auth_provider = 'local'";
        try (Connection connection = DBconnect.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, newPassword);
            stmt.setString(2, email);
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error updating password for email: " + email, e);
        }
    }
    public boolean updateImage(int id, String image) {
        String sql = "UPDATE users SET image = ? WHERE userID = ?";
        try (Connection con = DBconnect.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, image);
            stmt.setInt(2, id);
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int getUserIdByCandidateId(int candidateId) {
        String sql = "SELECT u.userID FROM users u " +
                "JOIN candidates c ON c.userId = u.userId " +
                "WHERE c.candidateId = ?";
        try (Connection connection = DBconnect.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, candidateId);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next() ? rs.getInt(1) : 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getIsOnlineByUserID(int userID) {
        String sql = "SELECT isOnline FROM online_users WHERE userID = ?";
        try (Connection con = DBconnect.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, userID);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next() ? rs.getInt(1) : 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateIsOnline(int id, int online) {
        String sql = "UPDATE online_users SET isOnline = ?, LastActive = ? WHERE userID = ?";
        try (Connection con = DBconnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, online);
            ps.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
            ps.setInt(3, id);
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getLockStatus(int userId) {
        String sql = "SELECT status FROM users WHERE userID = ?";
        try (Connection con = DBconnect.getConnection();
             PreparedStatement prep = con.prepareStatement(sql)) {

            prep.setInt(1, userId);
            try (ResultSet rs = prep.executeQuery()) {
                return rs.next() ? rs.getInt(1) : -2;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User getUserById(int userID) {
        String sql = "SELECT u.userID, u.email, u.name, u.phone_number, u.status, u.created_at, u.image, " +
                "ua.provider_id, ua.password, r.roleNum " +
                "FROM users u " +
                "LEFT JOIN user_auth ua ON u.userID = ua.userID " +
                "LEFT JOIN roles r ON u.userID = r.userID " +
                "WHERE u.userID = ?";

        try (Connection con = DBconnect.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, userID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    User user = new User();
                    user.setUserID(rs.getInt("userID"));
                    user.setEmail(rs.getString("email"));
                    user.setName(rs.getString("name"));
                    user.setPhone_number(rs.getString("phone_number"));
                    user.setStatus(rs.getInt("status"));
                    user.setImage(rs.getString("image"));

                    Timestamp ts = rs.getTimestamp("created_at");
                    if (ts != null) user.setCreated_at(ts.toLocalDateTime());

                    user.setProvider_id(rs.getString("provider_id"));
                    user.setRoleNum(rs.getInt("roleNum"));
                    return user;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public boolean updateUser(User user) {
        String sql = "UPDATE users SET name = ?, phone_number = ?, image = ? WHERE userID = ?";

        try (Connection con = DBconnect.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getPhone_number());
            stmt.setString(3, user.getImage());
            stmt.setInt(4, user.getUserID());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getPasswordByUserId(int userID) {
        String sql = "SELECT password FROM user_auth WHERE userID = ?";

        try (Connection con = DBconnect.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, userID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("password");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public int getPermissionIdForAdmin(int userID) {
        String sql = "SELECT permission_id FROM user_permissions WHERE userId = ?";

        try (Connection con = DBconnect.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, userID);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next() ? rs.getInt(1) : 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean insertPermissionIdForAdmin(int userId, int permissionId) {
        String sql = "INSERT INTO user_permissions(userId, Permission_Id) VALUES (?, ?)";

        try (Connection con = DBconnect.getConnection();
             PreparedStatement prep = con.prepareStatement(sql)) {

            prep.setInt(1, userId);
            prep.setInt(2, permissionId);
            return prep.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updatePermissionIdForAdmin(int userId, int permissionId) {
        String sql = "UPDATE user_permissions SET Permission_Id = ? WHERE userId = ?";

        try (Connection connection = DBconnect.getConnection();
             PreparedStatement prep = connection.prepareStatement(sql)) {

            prep.setInt(1, permissionId);
            prep.setInt(2, userId);
            return prep.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean updateChanged(int uid, int changed) {
        String sql = "UPDATE user_changes SET changed = ? WHERE userID = ?";

        try (Connection con = DBconnect.getConnection();
             PreparedStatement prep = con.prepareStatement(sql)) {

            prep.setInt(1, changed);
            prep.setInt(2, uid);
            return prep.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int getChanged(int uid) {
        String sql = "SELECT changed FROM user_changes WHERE userID = ?";
        int changed = -1;

        try (Connection connection = DBconnect.getConnection();
             PreparedStatement prep = connection.prepareStatement(sql)) {

            prep.setInt(1, uid);
            try (ResultSet rs = prep.executeQuery()) {
                if (rs.next()) {
                    changed = rs.getInt("changed");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return changed;
    }
    public static void main(String[] args) {
        UserDao dao = new UserDao();
//        System.out.println(dao.insertUser("22","1","vanduc","2222","local","g22"));
         System.out.println(dao.updateImage(28,"https://moc247.com/wp-content/uploads/2023/12/loa-mat-voi-101-hinh-anh-avatar-meo-cute-dang-yeu-dep-mat_2.jpg"));
    }


    public boolean insertChanged(int uid, int changed) {
        String sql = "INSERT INTO user_changes(userID, changed) VALUES (?, ?)";

        try (Connection con = DBconnect.getConnection();
             PreparedStatement prep = con.prepareStatement(sql)) {

            prep.setInt(1, uid);
            prep.setInt(2, changed);
            return prep.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

