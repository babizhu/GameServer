package org.bbz.game.db.gen;

import org.bbz.util.db.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * 该文件自动生成, 禁止手动修改!
 * 模版
 *
 * @author GEN_ROBOT
 *         2013-11-26 18:05:50
 */
public enum FormationDataProvider {

    INSTANCE;

    //private static AtomicLong idMax = null;

    public void add(Formation formation) {

        Connection con = DatabaseUtil.INSTANCE.getConnection();
        PreparedStatement pst = null;
        String sql = "insert into formation ( userName,templetId,levels ) "
                + "values ( ?,?,? )";

        try {
            pst = con.prepareStatement(sql);

            pst.setString(1, formation.getUserName());
            pst.setInt(2, formation.getTempletId());
            pst.setInt(3, formation.getLevels());


            pst.executeUpdate();

        } catch (SQLException e) {

            //throw new SQLRuntimeException(e);

        } finally {

            DatabaseUtil.INSTANCE.close(null, pst, con);
        }
    }

    public List<Formation> findBy(String field, String condition) {

        List<Formation> list = new ArrayList<Formation>();
        Connection con = DatabaseUtil.INSTANCE.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from formation where " + field + "=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, condition);
            rs = ps.executeQuery();

            while (rs.next()) {

//                CLASS_PARAMETER = mapping(rs);

            }

        } catch (SQLException e) {


        } finally {

            DatabaseUtil.INSTANCE.close(rs, ps, con);
        }

        return list;
    }

}
