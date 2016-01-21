package com.mahmut.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mahmut.model.Ogrenci;

@Repository
public class OgrenciDaoImpl implements OgrenciDao {

	private static final Logger log = LoggerFactory.getLogger(OgrenciDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Ogrenci> listOgrenci() {
		Session session = sessionFactory.getCurrentSession();

		List<Ogrenci> list = session.createQuery("From Ogrenci").list();
		for (Ogrenci ogrenci : list) {
			log.info("Ogrenci Listesi  : " + ogrenci);
		}

		return list;
	}

	@Override
	public void ekleOgrenci(Ogrenci ogrenci) {
		Session session = sessionFactory.getCurrentSession();
		session.save(ogrenci);

		log.info("Ogrenci Kaydedildi." + ogrenci);
	}

	@Override
	public void silOgrenci(long id) {

		Ogrenci ogrenci = new Ogrenci();
		ogrenci.setId(id);
		Session session = sessionFactory.getCurrentSession();

		session.delete(ogrenci);
		log.info("Ogrenci Silindi." + ogrenci);

	}

	@Override
	public void guncelleOgrenci(Ogrenci ogrenci) {
		Session session = sessionFactory.getCurrentSession();
		session.update(ogrenci);

		log.info("Ogrenci Guncellendi. " + ogrenci);
	}

	@Override
	public Ogrenci getById(long id) {
		Session session = sessionFactory.getCurrentSession();
		Ogrenci ogrenci = session.load(Ogrenci.class, new Long(id));

		log.info("Ogrenci yuklendi." + ogrenci);
		return ogrenci;
	}

}
