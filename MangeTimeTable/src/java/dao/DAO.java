/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbContext.DBContext;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Classes;
import model.Room;
import model.Slot;
import model.Teacher;
import model.TimeTable;

/**
 *
 * @author nhatbeo
 */
public class DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
        public List<TimeTable> getAllTimeTable() {
        List<TimeTable> list = new ArrayList<>();
        // Create and execute an SQL statement that returns some data.
        String sql = "SELECT Date,\n"
                + "       SlotName,\n"
                + "       TimeFrom,\n"
                + "       TimeTo,\n"
                + "       ClassName,\n"
                + "       TeacherCode,\n"
                + "       RoomName\n"
                + "FROM dbo.TimeTable\n"
                + "    JOIN dbo.Class\n"
                + "        ON Class.ClassID = TimeTable.ClassID\n"
                + "    JOIN dbo.Room\n"
                + "        ON Room.RoomID = TimeTable.RoomID\n"
                + "    JOIN dbo.Slot\n"
                + "        ON Slot.SlotID = TimeTable.SlotID\n"
                + "    JOIN dbo.Teacher\n"
                + "        ON Teacher.TeacherID = TimeTable.TeacherID;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            // Iterate through the data in the result set and add it to list.
            while (rs.next()) {
                list.add(new TimeTable(rs.getDate("Date"),
                        rs.getString("SlotName"),
                        rs.getTime("TimeFrom"),
                        rs.getTime("TimeTo"),
                        rs.getString("ClassName"),
                        rs.getString("TeacherCode"),
                        rs.getString("RoomName")));
            }
        } // Handle any errors that may have occurred.
        catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
                /* Ignored */ }
            try {
                ps.close();
            } catch (Exception e) {
                /* Ignored */ }
            try {
                conn.close();
            } catch (Exception e) {
                /* Ignored */ }
        }
        return list;
    }

    public List<TimeTable> searchTimeTableByDate(String from, String to) {
        List<TimeTable> list = new ArrayList<>();
        // Create and execute an SQL statement that returns some data.
        String sql = "SELECT Date,\n"
                + "       SlotName,\n"
                + "       TimeFrom,\n"
                + "       TimeTo,\n"
                + "       ClassName,\n"
                + "       TeacherCode,\n"
                + "       RoomName\n"
                + "FROM dbo.TimeTable\n"
                + "    JOIN dbo.Class\n"
                + "        ON Class.ClassID = TimeTable.ClassID\n"
                + "    JOIN dbo.Room\n"
                + "        ON Room.RoomID = TimeTable.RoomID\n"
                + "    JOIN dbo.Slot\n"
                + "        ON Slot.SlotID = TimeTable.SlotID\n"
                + "    JOIN dbo.Teacher\n"
                + "        ON Teacher.TeacherID = TimeTable.TeacherID\n"
                + "WHERE 1 = 1\n";
        if (from != "") {
            sql += " AND [Date] >= " + "'" + from + "'";
        }
        if (to != "") {
            sql += " AND [Date] <= " + "'" + to + "'";
        }
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            // Iterate through the data in the result set and add it to list.
            while (rs.next()) {
                list.add(new TimeTable(rs.getDate("Date"),
                        rs.getString("SlotName"),
                        rs.getTime("TimeFrom"),
                        rs.getTime("TimeTo"),
                        rs.getString("ClassName"),
                        rs.getString("TeacherCode"),
                        rs.getString("RoomName")));
            }
        } // Handle any errors that may have occurred.
        catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
                /* Ignored */ }
            try {
                ps.close();
            } catch (Exception e) {
                /* Ignored */ }
            try {
                conn.close();
            } catch (Exception e) {
                /* Ignored */ }
        }
        return list;
    }

    public List<Slot> getAllSlot() {
        List<Slot> list = new ArrayList<>();
        // Create and execute an SQL statement that returns some data.
        String sql = "SELECT * FROM dbo.Slot";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            // Iterate through the data in the result set and add it to list.
            while (rs.next()) {
                list.add(new Slot(rs.getInt("SlotID"), rs.getString("SlotName")));
            }
        } // Handle any errors that may have occurred.
        catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
                /* Ignored */ }
            try {
                ps.close();
            } catch (Exception e) {
                /* Ignored */ }
            try {
                conn.close();
            } catch (Exception e) {
                /* Ignored */ }
        }
        return list;
    }

    public List<Room> getAllRoom() {
        List<Room> list = new ArrayList<>();
        // Create and execute an SQL statement that returns some data.
        String sql = "SELECT * FROM dbo.Room";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            // Iterate through the data in the result set and add it to list.
            while (rs.next()) {
                list.add(new Room(rs.getInt("RoomID"), rs.getString("RoomName")));
            }
        } // Handle any errors that may have occurred.
        catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
                /* Ignored */ }
            try {
                ps.close();
            } catch (Exception e) {
                /* Ignored */ }
            try {
                conn.close();
            } catch (Exception e) {
                /* Ignored */ }
        }
        return list;
    }

    public List<Teacher> getAllTeacher() {
        List<Teacher> list = new ArrayList<>();
        // Create and execute an SQL statement that returns some data.
        String sql = "SELECT * FROM dbo.Teacher";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            // Iterate through the data in the result set and add it to list.
            while (rs.next()) {
                list.add(new Teacher(rs.getInt("TeacherID"), rs.getString("TeacherName"), rs.getString("TeacherCode")));
            }
        } // Handle any errors that may have occurred.
        catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
                /* Ignored */ }
            try {
                ps.close();
            } catch (Exception e) {
                /* Ignored */ }
            try {
                conn.close();
            } catch (Exception e) {
                /* Ignored */ }
        }
        return list;
    }

    public List<Classes> getAllClasses() {
        List<Classes> list = new ArrayList<>();
        // Create and execute an SQL statement that returns some data.
        String sql = "SELECT * FROM dbo.Class";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            // Iterate through the data in the result set and add it to list.
            while (rs.next()) {
                list.add(new Classes(rs.getInt("ClassID"), rs.getString("ClassName")));
            }
        } // Handle any errors that may have occurred.
        catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
                /* Ignored */ }
            try {
                ps.close();
            } catch (Exception e) {
                /* Ignored */ }
            try {
                conn.close();
            } catch (Exception e) {
                /* Ignored */ }
        }
        return list;
    }

    public boolean checkRoomAvailable(int roomId, int slotId, Date date) {
        // Create and execute an SQL statement that returns some data.
        String sql = "SELECT *\n"
                + "FROM dbo.TimeTable\n"
                + "WHERE RoomID = ?\n"
                + "      AND SlotID = ?\n"
                + "      AND [Date] = ?;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, roomId);
            ps.setInt(2, slotId);
            ps.setDate(3, date);
            rs = ps.executeQuery();
            // if found result, room isn't available
            while (rs.next()) {
                return false;
            }
        } // Handle any errors that may have occurred.
        catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }

    public boolean checkClassAvailable(int slotId, int classId, Date date) {
        // Create and execute an SQL statement that returns some data.
        String sql = "SELECT *\n"
                + "FROM dbo.TimeTable\n"
                + "WHERE SlotID = ?\n"
                + "      AND ClassID = ?\n"
                + "      AND [Date] = ?;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, slotId);
            ps.setInt(2, classId);
            ps.setDate(3, date);
            rs = ps.executeQuery();
            // if found result, room isn't available
            while (rs.next()) {
                return false;
            }
        } // Handle any errors that may have occurred.
        catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }

    public boolean checkTeacherAvailable(int teacherId, int slotId, Date date) {
        // Create and execute an SQL statement that returns some data.
        String sql = "SELECT *\n"
                + "FROM dbo.TimeTable\n"
                + "WHERE 1 = 1\n"
                + "      AND SlotID = ?\n"
                + "      AND TeacherID = ?\n"
                + "      AND [Date] = ?;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, slotId);
            ps.setInt(2, teacherId);
            ps.setDate(3, date);
            rs = ps.executeQuery();
            // if found result, teacher isn't available
            while (rs.next()) {
                return false;
            }
        } // Handle any errors that may have occurred.
        catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }

    public void inserTimeTable(Date date, int slotId, int classId, int teacherId, int roomId) {
        // Create and execute an SQL statement that returns some data.
        String sql = "INSERT INTO [dbo].[TimeTable]\n"
                + "           ([Date]\n"
                + "           ,[SlotID]\n"
                + "           ,[ClassID]\n"
                + "           ,[TeacherID]\n"
                + "           ,[RoomID])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setDate(1, date);
            ps.setInt(2, slotId);
            ps.setInt(3, classId);
            ps.setInt(4, teacherId);
            ps.setInt(5, roomId);
            ps.executeUpdate();
        } // Handle any errors that may have occurred.
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
