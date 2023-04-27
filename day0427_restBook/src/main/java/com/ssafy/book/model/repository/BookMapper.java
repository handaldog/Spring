package com.ssafy.book.model.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.book.mode.dto.BookDto;

@Mapper
public interface BookMapper {

	public int insert(BookDto book);

	public List<BookDto> selectAll();

	public BookDto selectOne(int bno);

	public int remove(int bno);

}
