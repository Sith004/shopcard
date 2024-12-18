package com.mycompany.services;

import java.util.List;

import com.mycompany.models.HanghoaModel;

public interface HanghoaService {
	List<HanghoaModel>getAll();

	Boolean create(HanghoaModel hanghoa);
	 Boolean update(HanghoaModel hanghoa); 
	 Boolean delete(HanghoaModel hanghoa); 
}
