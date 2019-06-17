package com.stevelee.java.dto;

public class ReviewDto {

	
		int review_no;
		String review_user;
		String review_date;
		String review_title;
		String review_comp;
		String review_content;
		
		public ReviewDto() {
			
		}

		public ReviewDto(int review_no, String review_user, String review_date, String review_title, String review_comp,
				String review_content) {
			super();
			this.review_no = review_no;
			this.review_user = review_user;
			this.review_date = review_date;
			this.review_title = review_title;
			this.review_comp = review_comp;
			this.review_content = review_content;
		}

		public int getReview_no() {
			return review_no;
		}

		public void setReview_no(int review_no) {
			this.review_no = review_no;
		}

		public String getReview_user() {
			return review_user;
		}

		public void setReview_user(String review_user) {
			this.review_user = review_user;
		}

		public String getReview_date() {
			return review_date;
		}

		public void setReview_date(String review_date) {
			this.review_date = review_date;
		}

		public String getReview_title() {
			return review_title;
		}

		public void setReview_title(String review_title) {
			this.review_title = review_title;
		}

		public String getReview_comp() {
			return review_comp;
		}

		public void setReview_comp(String review_comp) {
			this.review_comp = review_comp;
		}

		public String getReview_content() {
			return review_content;
		}

		public void setReview_content(String review_content) {
			this.review_content = review_content;
		}
		
		
		
		
		
}
