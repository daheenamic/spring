package org.zerock.board.mapper;

import java.util.List;
import org.zerock.board.vo.BoardVO;
import com.webjjang.util.PageObject;

public interface BoardMapper {
	
	public List<BoardVO> list(PageObject pageObject);
	
	public long getTotalRow(PageObject pageObject);
	
	public BoardVO view(long no);
	
	public Integer increase(long no);
	
	public Integer write(BoardVO vo);
	
	public Integer update(BoardVO vo);
	
	public Integer delete(BoardVO vo);
	
}
