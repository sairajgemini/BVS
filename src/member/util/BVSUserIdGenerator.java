package member.util;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BVSUserIdGenerator implements IdentifierGenerator {

    public Serializable generate(SharedSessionContractImplementor session, Object object)
            throws HibernateException {
        Log log = LogFactory.getLog(BVSUserIdGenerator.class);
        String prefix = "BVS";
        Connection connection = session.connection();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = connection
                    .prepareStatement("SELECT nextval ('bvs_userid_seq') as nextval");

            rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("nextval");
                String code = prefix + StringUtils.leftPad("" + id, 5, '0');
                log.debug("Generated code : " + code);
                return code;
            }
        } catch (SQLException e) {
            log.debug("Sequence 'bvs_userid_seq' not found.");
        }

        return null;
    }
}