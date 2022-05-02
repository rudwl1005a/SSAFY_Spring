package com.mycom.happyHouse.service;

import java.util.List;

import com.mycom.happyHouse.dto.HouseDealDto;
import com.mycom.happyHouse.dto.HouseInfoDto;
import com.mycom.happyHouse.dto.HouseSearchParamDto;
import com.mycom.happyHouse.dto.HouseSearchResultDto;

public interface HouseService {
	
	HouseSearchResultDto getSearchHouseInfo(HouseSearchParamDto dto);
	
	HouseInfoDto getHouseInfoByAptCode(int aptCode);
	
	List<HouseDealDto> getHouseDealList(int aptCode);
}
