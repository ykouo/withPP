package model.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	@Autowired
	private SpringBoardDAO boardDAO; // alt+shift+R -> �̸� �ѹ��� ���� ����!
	
	@Override
	public void insertBoard(BoardVO vo) {
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);	
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}

	@Override
	public List<BoardVO> searchBoard(BoardVO vo) {
		return boardDAO.searchBoard(vo);
	}
	@Override
	public List<BoardVO> getSearchBoardList(BoardVO vo,int startRow, int endRow) {
		return boardDAO.getSearchBoardList(vo,startRow, endRow);
	}

	@Override
	public int getBoardCnt() {
		return boardDAO.getBoardCnt();
	}

	@Override
	public List<BoardVO> getBoardList(int startRow, int endRow) {
		return boardDAO.getBoardList(startRow, endRow);
	}
	

}
