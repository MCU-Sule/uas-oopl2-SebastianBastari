package com.example.uaspbo2.DAO;
/**
 * Sebastian Giovanni Bastari 1972006
 */
import com.example.uaspbo2.Util.HibernateUtil;
import com.example.uaspbo2.model.FeMemberEntity;
import javafx.collections.FXCollections;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class feMemberDAO implements DAOinterface<FeMemberEntity>{


    @Override
    public int addData(FeMemberEntity data) {
        Session s = HibernateUtil.getSession();

        Transaction t = s.beginTransaction();
        s.save(data);
        t.commit();
        s.close();

        return 0 ;
    }

    @Override
    public int delData(FeMemberEntity data) {
        Session s = HibernateUtil.getSession();

        Transaction t = s.beginTransaction();
        s.delete(data);
        t.commit();
        s.close();

        return 0 ;
    }

    @Override
    public int updateData(FeMemberEntity data) {
        Session s = HibernateUtil.getSession();

        Transaction t = s.beginTransaction();
        s.update(data);
        t.commit();
        s.close();

        return 0 ;
    }

    @Override
    public List<FeMemberEntity> showData() {
        Session s = HibernateUtil.getSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(FeMemberEntity.class);

        query.from(FeMemberEntity.class);

        List<FeMemberEntity> clist = s.createQuery(query).getResultList();
        s.close();

        return FXCollections.observableArrayList(clist);
    }
}
