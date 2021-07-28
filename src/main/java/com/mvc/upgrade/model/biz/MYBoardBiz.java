package com.mvc.upgrade.model.biz;

import java.util.List;

import com.mvc.upgrade.model.dto.MYBoardDto;

public interface MYBoardBiz {

	public List<MYBoardDto> selectList();
	public MYBoardDto selectOne(int myno);
	public int insert(MYBoardDto dto);
	public int update(MYBoardDto dto);
	public int delete(int myno);
}
