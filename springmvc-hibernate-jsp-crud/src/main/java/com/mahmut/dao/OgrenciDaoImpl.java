package com.mahmut.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mahmut.model.Ogrenci;

@Repository
public class OgrenciDaoImpl implements OgrenciDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Ogrenci> listOgrenci() {
		Session session = sessionFactory.getCurrentSession();

		List<Ogrenci> list = session.createQuery("From Ogrenci").list();

		return list;
	}

	@Override
	public void ekleOgrenci(Ogrenci ogrenci) {
		Session session = sessionFactory.getCurrentSession();
		session.save(ogrenci);

	}

	@Override
	public void silOgrenci(long id) {

		Ogrenci ogrenci = new Ogrenci();
		ogrenci.setId(id);
		Session session = sessionFactory.getCurrentSession();

		session.delete(ogrenci);

	}

	@Override
	public void guncelleOgrenci(Ogrenci ogrenci) {
		Session session = sessionFactory.getCurrentSession();
		session.update(ogrenci);

	}

	@Override
	public Ogrenci getById(long id) {
		Session session = sessionFactory.getCurrentSession();
		Ogrenci ogrenci = session.load(Ogrenci.class, new Long(id));

		return ogrenci;
	}

}
