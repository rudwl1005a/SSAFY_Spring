package com.mycom.happyHouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.happyHouse.dto.HouseInfoDto;
import com.mycom.happyHouse.dto.HouseSearchParamDto;
import com.mycom.happyHouse.dto.HouseSearchResultDto;
import com.mycom.happyHouse.service.HouseService;

@RestController
@RequestMapping("/aparts")
public class HouseController {
	@Autowired
	HouseService houseService;
	
	@GetMapping(value="/all") 
	private ResponseEntity<HouseSearchResultDto> houseList(HouseSearchParamDto dto) {
		System.out.println("call /aparts?" + dto);
		HouseSearchResultDto result = houseService.getSearchHouseInfo(dto);
		
		if(result != null){// && !list.isEmpty()) {
			System.out.println("result : Success" );
			return new ResponseEntity<HouseSearchResultDto>(result, HttpStatus.OK);
		}
		else {
			System.out.println("result : Failed" );
			return new ResponseEntity<HouseSearchResultDto>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/{aptCode}") 
	private ResponseEntity<HouseInfoDto> houseDetail(@PathVariable int aptCode) {
		System.out.println("call /aparts/" + aptCode);
		HouseInfoDto dto = houseService.getHouseInfoByAptCode(aptCode);
		
		if(dto != null) {
			System.out.println("result : Success" );
			return new ResponseEntity<HouseInfoDto>(dto, HttpStatus.OK);
		}
		else {
			System.out.println("result : Failed" );
			return new ResponseEntity<HouseInfoDto>(dto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
}
