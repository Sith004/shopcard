package com.mycompany.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.models.HanghoaModel;
import com.mycompany.repository.HanghoaRepository;
@Service
public class HanghoaServiceImpl implements HanghoaService{
	@Autowired  
	 private HanghoaRepository hanghoaRepository;  
	 
	 @Override
		public List<HanghoaModel> getAll() {
			// TODO Auto-generated method stub
			return this.hanghoaRepository.findAll();
		}

		@Override
		public Boolean create(HanghoaModel hanghoa) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Boolean update(HanghoaModel hanghoa) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Boolean delete(HanghoaModel hanghoa) {
			// TODO Auto-generated method stub
			return null;
		}
}
