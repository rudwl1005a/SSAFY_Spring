package com.mycom.happyHouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.happyHouse.dto.HouseDealDto;
import com.mycom.happyHouse.dto.HouseInfoDto;
import com.mycom.happyHouse.dto.HouseSearchParamDto;
import com.mycom.happyHouse.dto.HouseSearchResultDto;

@Mapper
public interface HouseDao {
	List<com.mycom.happyHouse.dto.HouseInfoDto> getSearchHouseInfo(HouseSearchParamDto dto);
	
	int getCountHouseInfo(HouseSearchParamDto dto);
	
	HouseInfoDto getHouseInfoByAptCode(int aptCode);
	
	List<HouseDealDto> getHouseDealList(int aptCode);
	
}
