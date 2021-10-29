package model.postforcafe;

public class Pagenation {
	// ������� 
		private int pageSize; // �� ���������� ���� �Խñ� �� 
		private int firstPageNum; // ù��° ������ ��ȣ
		private int prevPageNum; // ���� ������ ��ȣ
		private int startPageNum; // ���������� (����¡�׺����)
		private int pageNum; // ������ ��ȣ
		private int endPageNum; // ������ ������ (����¡�׺����)
		private int nextPageNum; // ���� ������ ��ȣ
		private int finalPageNum; // ������ ������ ��ȣ
		private int totalCount; //  �Խñ� ��ü �� 
		
		// Getter & Setter
		public int getPageSize() {
			return pageSize;
		}
		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}
		public int getFirstPageNum() {
			return firstPageNum;
		}
		public void setFirstPageNum(int firstPageNum) {
			this.firstPageNum = firstPageNum;
		}
		public int getPrevPageNum() {
			return prevPageNum;
		}
		public void setPrevPageNum(int prevPageNum) {
			this.prevPageNum = prevPageNum;
		}
		public int getStartPageNum() {
			return startPageNum;
		}
		public void setStartPageNum(int startPageNum) {
			this.startPageNum = startPageNum;
		}
		public int getPageNum() {
			return pageNum;
		}
		public void setPageNum(int pageNum) {
			this.pageNum = pageNum;
		}
		public int getEndPageNum() {
			return endPageNum;
		}
		public void setEndPageNum(int endPageNum) {
			this.endPageNum = endPageNum;
		}
		public int getNextPageNum() {
			return nextPageNum;
		}
		public void setNextPageNum(int nextPageNum) {
			this.nextPageNum = nextPageNum;
		}
		public int getFinalPageNum() {
			return finalPageNum;
		}
		public void setFinalPageNum(int finalPageNum) {
			this.finalPageNum = finalPageNum;
		}
		public int getTotalCount() {
			return totalCount;
		}
		public void setTotalCount(int totalCount) {
			this.totalCount = totalCount;
			this.Paging();
		}
		
		// Paging()
		public void Paging() {
			if(this.totalCount==0) {	// �Խñ��� �ƿ� ���� ��� 
				return;
			}
			if(this.pageNum==0) { 		// �⺻�� ����
				this.setPageNum(1);
			}
			if(this.pageSize==0) {		// �⺻�� ����
				this.setPageSize(10);
			}
			
			int finalPage = (totalCount+(pageSize-1))/pageSize;
			// ex) total = 30 (30+(10-1))/10)=3
			System.out.println("finalPage="+finalPage);
			
			if(this.pageNum>finalPage) {	// ���� ������ ��ȣ�� ���������������� ũ�ٸ� 
				this.setPageNum(finalPage);	// ������������ȣ�� ������ ��������ȣ�� �����Ѵ�.
			}
			if(this.pageNum<0 || this.pageNum>finalPage) {	// ���� ������������ȣ�� 0���� �۰ų� ������������ ���� ũ�ٸ� 
				this.pageNum=1;	// ������������ȣ�� 1�� ����
			}
			
			boolean isNowFirst = pageNum == 1? true:false; // ������������ȣ�� 1�� ���� ��:����
			boolean isNowFinal = pageNum == finalPage? true:false; // ������������ 
			
			int startPage = ((pageNum-1)/10)*10+1; 
			int endPage = startPage+10-1; 
			
			if(endPage>finalPage) {
				endPage=finalPage;
			}
			this.setFirstPageNum(1);
			if(isNowFirst) {
				this.setPrevPageNum(1);
			}else {
				this.setPrevPageNum((pageNum-1)<1?1:(pageNum-1));
			}
			this.setStartPageNum(startPage);
			this.setEndPageNum(endPage);
		
			if(isNowFinal) {
				this.setNextPageNum(finalPage);
			}else {
				this.setNextPageNum((pageNum+1)>finalPage?finalPage:(pageNum+1));
			}
			this.setFinalPageNum(finalPage);
		}
		@Override
		public String toString() {
			return "Pagenation [pageSize=" + pageSize + ", firstPageNum=" + firstPageNum + ", prevPageNum=" + prevPageNum
					+ ", startPageNum=" + startPageNum + ", pageNum=" + pageNum + ", endPageNum=" + endPageNum
					+ ", nextPageNum=" + nextPageNum + ", finalPageNum=" + finalPageNum + ", totalCount=" + totalCount
					+ "]";
		}
}
