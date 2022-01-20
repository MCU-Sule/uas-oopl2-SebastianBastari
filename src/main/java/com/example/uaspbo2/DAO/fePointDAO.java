package com.example.uaspbo2.DAO;
/**
 * Sebastian Giovanni Bastari 1972006
 */
import com.example.uaspbo2.Util.HibernateUtil;
import com.example.uaspbo2.model.FeMemberEntity;
import com.example.uaspbo2.model.FePointEntity;
import javafx.collections.FXCollections;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class fePointDAO implements DAOinterface<FePointEntity>{

    @Override
    public int addData(FePointEntity data) {
        Session s = HibernateUtil.getSession();

        Transaction t = s.beginTransaction();
        s.save(data);
        t.commit();
        s.close();

        return 0 ;
    }

    @Override
    public int delData(FePointEntity data) {
        Session s = HibernateUtil.getSession();

        Transaction t = s.beginTransaction();
        s.delete(data);
        t.commit();
        s.close();

        return 0 ;
    }

    @Override
    public int updateData(FePointEntity data) {
        Session s = HibernateUtil.getSession();

        Transaction t = s.beginTransaction();
        s.update(data);
        t.commit();
        s.close();

        return 0 ;
    }

    @Override
    public List<FePointEntity> showData() {
        Session s = HibernateUtil.getSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(FePointEntity.class);

        query.from(FePointEntity.class);

        List<FePointEntity> clist = s.createQuery(query).getResultList();
        s.close();

        return FXCollections.observableArrayList(clist);
    }
}
