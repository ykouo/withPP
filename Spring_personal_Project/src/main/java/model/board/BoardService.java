package model.board;

import java.util.List;

public interface BoardService {
	void insertBoard(BoardVO vo); //C
	void updateBoard(BoardVO vo); //U
	void deleteBoard(BoardVO vo); //D
	BoardVO getBoard(BoardVO vo);	  // R - select one
	List<BoardVO> getBoardList(BoardVO vo); // R - select all 1
	List<BoardVO> searchBoard(BoardVO vo);  // R - select all 2
	List<BoardVO> getBoardList(int startRow, int endRow); // ���������̼ǿ� 
	int getBoardCnt(); // ī����
	List<BoardVO> getSearchBoardList(BoardVO vo, int startRow, int endRow);
}
