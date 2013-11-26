package #packageName#;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.bbz.util.db.DatabaseUtil;


/**
 * 该文件自动生成, 禁止手动修改!
 * 模版
 * @author GEN_ROBOT
 * #date
 */
public enum #className# {

    INSTANCE;

	//private static AtomicLong idMax = null;

	public void add( #DTOclassName# #DTOclassParam# ) {

		Connection con = DatabaseUtil.INSTANCE.getConnection();
        PreparedStatement pst = null;
        String sql = "insert into #tableName# ( #columnName# ) "
                            + "values ( #columnQuestionMark# )";

		try {
			pst = con.prepareStatement( sql );

			#pstAdd#

			pst.executeUpdate();

		} catch (SQLException e) {

			//throw new SQLRuntimeException(e);

		} finally {

            DatabaseUtil.INSTANCE.close( null, pst, con );
		}
	}

    public List<#DTOclassName#> findBy( String field, String condition ) {

            List<#DTOclassName#> list = new ArrayList<#DTOclassName#>();
            Connection con = DatabaseUtil.INSTANCE.getConnection();
    		PreparedStatement ps = null;
            ResultSet rs = null;

    		String sql = "select * from #tableName# where " + field + "=?";
    		try {
    			ps = con.prepareStatement(sql);
    			ps.setString( 1, condition );
    			rs = ps.executeQuery();

    			while (rs.next()) {

    			CLASS_PARAMETER = mapping(rs);

    			}

    		} catch (SQLException e) {



    		} finally {

    			DatabaseUtil.INSTANCE.close( rs, ps, con );
    		}

    		return list;
    	}

}
