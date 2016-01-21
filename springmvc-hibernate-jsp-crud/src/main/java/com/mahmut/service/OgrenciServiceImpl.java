package com.mahmut.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mahmut.dao.OgrenciDao;
import com.mahmut.model.Ogrenci;

@Service
@Transactional
public class OgrenciServiceImpl implements OgrenciService {

	@Autowired
	private OgrenciDao ogrenciDao;

	@Override
	public List<Ogrenci> listOgrenci() {

		return ogrenciDao.listOgrenci();
	}

	@Override
	public void ekleOgrenci(Ogrenci ogrenci) {
		ogrenciDao.ekleOgrenci(ogrenci);
		
	}

	@Override
	public void silOgrenci(long id) {
		ogrenciDao.silOgrenci(id);
		
	}

	@Override
	public void guncelleOgrenci(Ogrenci ogrenci) {
		ogrenciDao.guncelleOgrenci(ogrenci);
		
	}

	@Override
	public Ogrenci getById(long id) {
		 
		return ogrenciDao.getById(id);
	}

}
