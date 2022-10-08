package com.seleniumexpress.service;

import org.springframework.stereotype.Service;

@Service
public class LovecalculatorServiceImpl implements LoveCalculatorService {

	@Override
	public String calculateResult(String userName, String crushName) {
		// TODO Auto-generated method stub
		int length=userName.length()+crushName.length();
		
		int index=length%6;
		
		String flames=CharacterConstants.FLAME_STRING;
		char result=flames.charAt(index+1);
		switch(result)
		{
		case 'F': return CharacterConstants.F_CHAR;
		case 'L':return CharacterConstants.L_CHAR;
		case 'A':return CharacterConstants.A_CHAR;
		case 'M':return CharacterConstants.M_CHAR;
		case 'E':return CharacterConstants.E_CHAR;
		case 'S':return CharacterConstants.S_CHAR;
		
		}
		return "Nothing";
	}

}
