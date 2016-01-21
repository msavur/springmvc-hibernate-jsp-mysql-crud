package com.mahmut.service;

import java.util.List;

import com.mahmut.model.Ogrenci;

public interface OgrenciService {

	public List<Ogrenci> listOgrenci();

	public void ekleOgrenci(Ogrenci ogrenci);

	public void silOgrenci(long id);

	public void guncelleOgrenci(Ogrenci ogrenci);

	public Ogrenci getById(long id);

}
