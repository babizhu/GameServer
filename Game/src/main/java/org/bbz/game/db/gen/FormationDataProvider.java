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
 *         2013-12-11 17:29:20
 */
public enum FormationDataProvider{

    INSTANCE;

    //private static AtomicLong idMax = null;

    public void add( Formation formation, String userName ){
        PreparedStatement pst = null;
        String sql = "insert into formation ( userName,templetId,levels ) values ( ?,?,? )";
        Connection con = DatabaseUtil.INSTANCE.getConnection();

        try {
            pst = con.prepareStatement( sql );
            pst.setString( 1, formation.getUserName() );
            pst.setInt( 2, formation.getTempletId() );
            pst.setInt( 3, formation.getLevels() );

            pst.executeUpdate();

        } catch( SQLException e ) {
            e.printStackTrace();
        } finally {

            DatabaseUtil.INSTANCE.close( null, pst, con );
        }
    }

    public List<Formation> findBy( String field, String condition ){

        List<Formation> list = new ArrayList<Formation>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        Formation formation;
        String sql = String.format( "SELECT * FROM formation WHERE %s=?", field );
        Connection con = DatabaseUtil.INSTANCE.getConnection();

        try {
            pst = con.prepareStatement( sql );
            pst.setString( 1, condition );
            rs = pst.executeQuery();

            while( rs.next() ) {
                formation = mapping( rs );
                list.add( formation );
            }
        } catch( SQLException e ) {
            e.printStackTrace();
        } finally {
            DatabaseUtil.INSTANCE.close( rs, pst, con );
        }

        return list;
    }

    private Formation mapping( ResultSet rs ) throws SQLException{

        Formation formation = new Formation();

        formation.setUserName( rs.getString( 1 ) );
        formation.setTempletId( rs.getInt( 2 ) );
        formation.setLevels( rs.getInt( 3 ) );

        return formation;
    }

    public void addAll( List<Formation> list, String userName ){
        PreparedStatement pst = null;
        StringBuilder sql = new StringBuilder( "INSERT INTO formation (userName,templetId,levels) VALUES " );
        for( Formation formation : list ) {
            sql.append( "(" );
            sql.append( String.format( "'%s',%s,%s", formation.getUserName(), formation.getTempletId(), formation.getLevels() ) );
            sql.append( ")," );
        }
        if( list.size() > 0 ) {
            sql.deleteCharAt( sql.length() - 1 );//去掉最后的逗号
        }
        Connection con = DatabaseUtil.INSTANCE.getConnection();

        try {
            pst = con.prepareStatement( sql.toString() );
            pst.executeUpdate();
        } catch( SQLException e ) {
            e.printStackTrace();
        } finally {
            DatabaseUtil.INSTANCE.close( null, pst, con );
        }
    }

    public void delete( Formation formation, String userName ){
        PreparedStatement pst = null;
        String sql = "delete from formation where templetId=? and userName=?";
        Connection con = DatabaseUtil.INSTANCE.getConnection();

        try {
            pst = con.prepareStatement( sql );
            pst.setInt( 1, formation.getTempletId() );
            pst.setString( 2, formation.getUserName() );

            pst.execute();

        } catch( SQLException e ) {
            e.printStackTrace();

        } finally {
            DatabaseUtil.INSTANCE.close( null, pst, con );
        }
    }

    public void update( Formation formation, String userName ){
        PreparedStatement pst = null;
        Connection con = DatabaseUtil.INSTANCE.getConnection();

        String sql = "update formation set levels=? where templetId=? and userName=?";

        try {
            pst = con.prepareStatement( sql );
            pst.setInt( 1, formation.getLevels() );
            pst.setInt( 2, formation.getTempletId() );
            pst.setString( 3, formation.getUserName() );

            pst.executeUpdate();

        } catch( SQLException e ) {
            e.printStackTrace();

        } finally {
            DatabaseUtil.INSTANCE.close( null, pst, con );
        }
    }

}
