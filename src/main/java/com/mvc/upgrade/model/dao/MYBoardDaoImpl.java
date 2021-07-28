package com.mvc.upgrade.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.upgrade.model.dto.MYBoardDto;

@Repository
public class MYBoardDaoImpl implements MYBoardDao {

	// @Autowired 이걸로 좀전에 설정들 잡은거(순서 08번) 연결하기!
	// 필드 주입, 메소드 주입할 수 있다.
	// 이떄 똑같은 타입이 2개가 있으면 안된다! (타입으로 찾기때문에!)
	// 2개 만들었으면 둘중에 하나 가지고 올 수 있는 qulif... 속성 쓸 수 있다.
	// 해서 특정 빈을 주입해주겠다! 로..
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<MYBoardDto> selectList() {
		
		List<MYBoardDto> list = new ArrayList<MYBoardDto>();
		
		try {
			list = sqlSession.selectList(NAMESPACE + "selectList");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public MYBoardDto selectOne(int myno) {
		
		MYBoardDto dto = null;
		
		try {
			dto = sqlSession.selectOne(NAMESPACE + "selectOne", myno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}

	@Override
	public int insert(MYBoardDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE + "insert", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int update(MYBoardDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.update(NAMESPACE + "update", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int delete(int myno) {
		int res = 0;
		
		try {
			res = sqlSession.delete(NAMESPACE + "delete", myno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

}
