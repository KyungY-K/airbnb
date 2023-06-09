package com.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.*;
import javax.sql.DataSource;

public class HouseDAO {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;

	private static HouseDAO instance;

	public HouseDAO() {}
	
	public static HouseDAO getInstance() {
		if (instance == null) {
			instance = new HouseDAO();
		}
		return instance;
	}
	
	public void openConn() {
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/myoracle");
			con = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void closeConn(ResultSet rs, PreparedStatement pstmt, Connection con) {
		try {
			if (pstmt !=null) { pstmt.close(); }
			if (con != null) { con.close(); }
			if (rs !=null) { rs.close(); }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<HouseDTO> getHouseList() {
		openConn();
		List<HouseDTO> list = new ArrayList<HouseDTO>();
		try {
			sql = "select * from house order by house_no desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();	
			
			while (rs.next()) {
				HouseDTO dto = new HouseDTO();
				
				dto.setHouse_no(rs.getInt("house_no"));
				dto.setHouse_owner(rs.getString("house_owner"));
				dto.setHouse_name(rs.getString("house_name"));
				dto.setHouse_category(rs.getString("house_category"));
				dto.setHouse_location(rs.getString("house_location"));
				dto.setHouse_price(rs.getInt("house_price"));
				dto.setHouse_content(rs.getString("house_content"));
				dto.setHouse_phone(rs.getString("house_phone"));
				dto.setHouse_person(rs.getInt("house_person"));
				dto.setHouse_star(rs.getFloat("house_star"));
				dto.setHouse_update(rs.getString("house_update"));
				dto.setHouse_img1(rs.getString("house_img1"));
				dto.setHouse_img2(rs.getString("house_img2"));
				dto.setHouse_img3(rs.getString("house_img3"));
				dto.setHouse_count(rs.getInt("house_count"));
				dto.setHouse_water(rs.getInt("house_water"));
				dto.setHouse_pool(rs.getInt("house_pool"));
				dto.setHouse_ski(rs.getInt("house_ski"));
				dto.setHouse_food(rs.getInt("house_food"));
				dto.setHouse_parking(rs.getInt("house_parking"));
				dto.setHouse_grill(rs.getInt("house_grill"));
				dto.setHouse_smoking(rs.getInt("house_smoking"));
				dto.setHouse_gym(rs.getInt("house_gym"));
								
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		return list;
	}

	public List<HouseDTO> categoryList(String cate) {
		openConn();
		List<HouseDTO> list = new ArrayList<HouseDTO>();
		try {
			sql = "select * from house where house_category = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cate);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				HouseDTO dto = new HouseDTO();
				
				dto.setHouse_no(rs.getInt("house_no"));
				dto.setHouse_owner(rs.getString("house_owner"));
				dto.setHouse_name(rs.getString("house_name"));
				dto.setHouse_category(rs.getString("house_category"));
				dto.setHouse_location(rs.getString("house_location"));
				dto.setHouse_price(rs.getInt("house_price"));
				dto.setHouse_content(rs.getString("house_content"));
				dto.setHouse_phone(rs.getString("house_phone"));
				dto.setHouse_person(rs.getInt("house_person"));
				dto.setHouse_star(rs.getFloat("house_star"));
				dto.setHouse_update(rs.getString("house_update"));
				dto.setHouse_img1(rs.getString("house_img1"));
				dto.setHouse_img2(rs.getString("house_img2"));
				dto.setHouse_img3(rs.getString("house_img3"));
				dto.setHouse_count(rs.getInt("house_count"));
				dto.setHouse_water(rs.getInt("house_water"));
				dto.setHouse_pool(rs.getInt("house_pool"));
				dto.setHouse_ski(rs.getInt("house_ski"));
				dto.setHouse_food(rs.getInt("house_food"));
				dto.setHouse_parking(rs.getInt("house_parking"));
				dto.setHouse_grill(rs.getInt("house_grill"));
				dto.setHouse_smoking(rs.getInt("house_smoking"));
				dto.setHouse_gym(rs.getInt("house_gym"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		return list;
	}
	
	public List<HouseDTO> categoryHotList() {
		openConn();
		List<HouseDTO> list = new ArrayList<HouseDTO>();
		try {
			sql = "select * from house order by house_count desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				HouseDTO dto = new HouseDTO();
				dto.setHouse_no(rs.getInt("house_no"));
				dto.setHouse_owner(rs.getString("house_owner"));
				dto.setHouse_name(rs.getString("house_name"));
				dto.setHouse_category(rs.getString("house_category"));
				dto.setHouse_location(rs.getString("house_location"));
				dto.setHouse_price(rs.getInt("house_price"));
				dto.setHouse_content(rs.getString("house_content"));
				dto.setHouse_phone(rs.getString("house_phone"));
				dto.setHouse_person(rs.getInt("house_person"));
				dto.setHouse_star(rs.getFloat("house_star"));
				dto.setHouse_update(rs.getString("house_update"));
				dto.setHouse_img1(rs.getString("house_img1"));
				dto.setHouse_img2(rs.getString("house_img2"));
				dto.setHouse_img3(rs.getString("house_img3"));
				dto.setHouse_count(rs.getInt("house_count"));
				dto.setHouse_water(rs.getInt("house_water"));
				dto.setHouse_pool(rs.getInt("house_pool"));
				dto.setHouse_ski(rs.getInt("house_ski"));
				dto.setHouse_food(rs.getInt("house_food"));
				dto.setHouse_parking(rs.getInt("house_parking"));
				dto.setHouse_grill(rs.getInt("house_grill"));
				dto.setHouse_smoking(rs.getInt("house_smoking"));
				dto.setHouse_gym(rs.getInt("house_gym"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		return list;
	}
	
	public List<HouseDTO> categoryStar() {
		openConn();
		List<HouseDTO> list = new ArrayList<HouseDTO>();
		try {
			sql = "select * from house order by house_star desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				HouseDTO dto = new HouseDTO();
				dto.setHouse_no(rs.getInt("house_no"));
				dto.setHouse_owner(rs.getString("house_owner"));
				dto.setHouse_name(rs.getString("house_name"));
				dto.setHouse_category(rs.getString("house_category"));
				dto.setHouse_location(rs.getString("house_location"));
				dto.setHouse_price(rs.getInt("house_price"));
				dto.setHouse_content(rs.getString("house_content"));
				dto.setHouse_phone(rs.getString("house_phone"));
				dto.setHouse_person(rs.getInt("house_person"));
				dto.setHouse_star(rs.getFloat("house_star"));
				dto.setHouse_update(rs.getString("house_update"));
				dto.setHouse_img1(rs.getString("house_img1"));
				dto.setHouse_img2(rs.getString("house_img2"));
				dto.setHouse_img3(rs.getString("house_img3"));
				dto.setHouse_count(rs.getInt("house_count"));
				dto.setHouse_water(rs.getInt("house_water"));
				dto.setHouse_pool(rs.getInt("house_pool"));
				dto.setHouse_ski(rs.getInt("house_ski"));
				dto.setHouse_food(rs.getInt("house_food"));
				dto.setHouse_parking(rs.getInt("house_parking"));
				dto.setHouse_grill(rs.getInt("house_grill"));
				dto.setHouse_smoking(rs.getInt("house_smoking"));
				dto.setHouse_gym(rs.getInt("house_gym"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		return list;
	}
	
	public List<HouseDTO> categoryPriceList() {
		openConn();
		List<HouseDTO> list = new ArrayList<HouseDTO>();
		try {
			sql = "select * from house order by house_price desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				HouseDTO dto = new HouseDTO();
				dto.setHouse_no(rs.getInt("house_no"));
				dto.setHouse_owner(rs.getString("house_owner"));
				dto.setHouse_name(rs.getString("house_name"));
				dto.setHouse_category(rs.getString("house_category"));
				dto.setHouse_location(rs.getString("house_location"));
				dto.setHouse_price(rs.getInt("house_price"));
				dto.setHouse_content(rs.getString("house_content"));
				dto.setHouse_phone(rs.getString("house_phone"));
				dto.setHouse_person(rs.getInt("house_person"));
				dto.setHouse_star(rs.getFloat("house_star"));
				dto.setHouse_update(rs.getString("house_update"));
				dto.setHouse_img1(rs.getString("house_img1"));
				dto.setHouse_img2(rs.getString("house_img2"));
				dto.setHouse_img3(rs.getString("house_img3"));
				dto.setHouse_count(rs.getInt("house_count"));
				dto.setHouse_water(rs.getInt("house_water"));
				dto.setHouse_pool(rs.getInt("house_pool"));
				dto.setHouse_ski(rs.getInt("house_ski"));
				dto.setHouse_food(rs.getInt("house_food"));
				dto.setHouse_parking(rs.getInt("house_parking"));
				dto.setHouse_grill(rs.getInt("house_grill"));
				dto.setHouse_smoking(rs.getInt("house_smoking"));
				dto.setHouse_gym(rs.getInt("house_gym"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		return list;
	}
	
	public List<HouseDTO> categoryOption(int water, int pool, int ski, int grill, int smoking, int gym) {
		openConn();
		List<HouseDTO> list = new ArrayList<HouseDTO>();
		try {
			if (water == 1) {
				sql = "select * from house where house_water = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, water);
			} else if (pool == 1) {
				sql = "select * from house where house_pool = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, pool);				
			} else if (ski == 1) {
				sql = "select * from house where house_ski = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, ski);				
			} else if (grill == 1) {
				sql = "select * from house where house_grill = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, grill);				
			} else if (smoking == 1) {
				sql = "select * from house where house_smoking = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, smoking);				
			} else if (gym == 1) {
				sql = "select * from house where house_gym = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, gym);				
			}
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				HouseDTO dto = new HouseDTO();
				dto.setHouse_no(rs.getInt("house_no"));
				dto.setHouse_owner(rs.getString("house_owner"));
				dto.setHouse_name(rs.getString("house_name"));
				dto.setHouse_category(rs.getString("house_category"));
				dto.setHouse_location(rs.getString("house_location"));
				dto.setHouse_price(rs.getInt("house_price"));
				dto.setHouse_content(rs.getString("house_content"));
				dto.setHouse_phone(rs.getString("house_phone"));
				dto.setHouse_person(rs.getInt("house_person"));
				dto.setHouse_star(rs.getFloat("house_star"));
				dto.setHouse_update(rs.getString("house_update"));
				dto.setHouse_img1(rs.getString("house_img1"));
				dto.setHouse_img2(rs.getString("house_img2"));
				dto.setHouse_img3(rs.getString("house_img3"));
				dto.setHouse_count(rs.getInt("house_count"));
				dto.setHouse_water(rs.getInt("house_water"));
				dto.setHouse_pool(rs.getInt("house_pool"));
				dto.setHouse_ski(rs.getInt("house_ski"));
				dto.setHouse_food(rs.getInt("house_food"));
				dto.setHouse_parking(rs.getInt("house_parking"));
				dto.setHouse_grill(rs.getInt("house_grill"));
				dto.setHouse_smoking(rs.getInt("house_smoking"));
				dto.setHouse_gym(rs.getInt("house_gym"));
				list.add(dto);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}		
		return list;
	}
	
	public HouseDTO selectHouseInfo(String houseNo) {
		openConn();
    	HouseDTO dto = new HouseDTO();
       
        try {
        	sql = "SELECT * FROM house WHERE house_no= ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setNString(1, houseNo);
            rs = pstmt.executeQuery();
            if (rs.next()) {            	
            	dto.setHouse_no(rs.getInt(1));
            	dto.setHouse_owner(rs.getString(2));
            	dto.setHouse_name(rs.getString(4));
            	dto.setHouse_category(rs.getString(5));
            	dto.setHouse_location(rs.getString(6));
            	dto.setHouse_price(rs.getInt(7));
            	dto.setHouse_content(rs.getString(8));
            	dto.setHouse_phone(rs.getString(9));
            	dto.setHouse_person(rs.getInt(10));
            	dto.setHouse_star(rs.getFloat(11));
            	dto.setHouse_img1(rs.getString(13));
            	dto.setHouse_img2(rs.getString(14));
            	dto.setHouse_img3(rs.getString(15));
				dto.setHouse_count(rs.getInt(16));
				dto.setHouse_water(rs.getInt(17));
				dto.setHouse_pool(rs.getInt(18));
				dto.setHouse_ski(rs.getInt(19));
				dto.setHouse_food(rs.getInt(20));
				dto.setHouse_parking(rs.getInt(21));
				dto.setHouse_grill(rs.getInt(22));
				dto.setHouse_smoking(rs.getInt(23));
				dto.setHouse_gym(rs.getInt(24));
				dto.setLatitude(rs.getString(25));
				dto.setLongitude(rs.getString(26));
            }
            
        } catch (SQLException e) {
            System.out.println("숙소 정보 조회 중 예외 발생");
            e.printStackTrace();
        } finally {
			closeConn(rs, pstmt, con);
		}
        return dto;
    }
	
	//kk
		public int deleteHouse(String no) {
			int result = 0;
			
			try {
				openConn();
				sql = "select * from house where house_no = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, no);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					sql = "delete from house where house_no = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, no);
					result = pstmt.executeUpdate();
				} else {
					result = -1;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				closeConn(rs, pstmt, con);
			}
			return result;
		}
		
		public void updateSequence(String no) {
			
			try {
				openConn();
				sql = "update house set house_no = house_no -1 where house_no > ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, no);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				closeConn(rs, pstmt, con);
			}
		}
		
		public HouseDTO getHouseCont(String no) {
			HouseDTO dto = null;
			
			try {
				openConn();
				sql = "select * from house where house_no = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, no);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					dto = new HouseDTO();
					dto.setHouse_no(rs.getInt("house_no"));
					dto.setHouse_owner(rs.getString("house_owner"));
					dto.setPmember_code(rs.getLong("pmember_code"));
					dto.setHouse_name(rs.getString("house_name"));
					dto.setHouse_category(rs.getString("house_category"));
					dto.setHouse_location(rs.getString("house_location"));
					dto.setHouse_price(rs.getInt("house_price"));
					dto.setHouse_content(rs.getString("house_content"));
					dto.setHouse_phone(rs.getString("house_phone"));
					dto.setHouse_person(rs.getInt("house_person"));
					dto.setHouse_star(rs.getFloat("house_star"));
					dto.setHouse_update(rs.getString("house_update"));
					dto.setHouse_img1(rs.getString("house_img1"));
					dto.setHouse_img2(rs.getString("house_img2"));
					dto.setHouse_img3(rs.getString("house_img3"));
					dto.setHouse_count(rs.getInt("house_count"));
					dto.setHouse_water(rs.getInt("house_water"));
					dto.setHouse_pool(rs.getInt("house_pool"));
					dto.setHouse_ski(rs.getInt("house_ski"));
					dto.setHouse_food(rs.getInt("house_food"));
					dto.setHouse_parking(rs.getInt("house_parking"));
					dto.setHouse_grill(rs.getInt("house_grill"));
					dto.setHouse_smoking(rs.getInt("house_smoking"));
					dto.setHouse_gym(rs.getInt("house_gym"));
					dto.setLatitude(rs.getString("latitude"));
					dto.setLongitude(rs.getString("longitude"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				closeConn(rs, pstmt, con);
			}
			return dto;
		}
		
		//유저코드 추가해야힘
		public int updateHouse(HouseDTO dto) {
			int result = 0;
			
			try {
				openConn();
				sql = "update house set house_name = ?, house_category = ?, house_location = ?, house_price = ?, house_content = ?, house_phone = ?, house_person = ?, sysdate, house_water = ?, house_pool = ?, house_ski = ?, house_food = ?, house_parking = ?, house_grill = ?, house_smoking = ?, house_gym = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, dto.getHouse_name());
				pstmt.setString(2, dto.getHouse_category());
				pstmt.setString(3, dto.getHouse_location());
				pstmt.setInt(4, dto.getHouse_price());
				pstmt.setString(5, dto.getHouse_content());
				pstmt.setString(6, dto.getHouse_phone());
				pstmt.setInt(7, dto.getHouse_person());
				pstmt.setString(8, dto.getHouse_img1());
				pstmt.setString(9, dto.getHouse_img2());
				pstmt.setString(10, dto.getHouse_img3());
				pstmt.setInt(8, dto.getHouse_water());
				pstmt.setInt(9, dto.getHouse_pool());
				pstmt.setInt(10, dto.getHouse_ski());
				pstmt.setInt(11, dto.getHouse_food());
				pstmt.setInt(12, dto.getHouse_parking());
				pstmt.setInt(13, dto.getHouse_grill());
				pstmt.setInt(14, dto.getHouse_smoking());
				pstmt.setInt(15, dto.getHouse_gym());
				
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				closeConn(rs, pstmt, con);
			}
			return result;
		}
		
		public int modifyUpload(HouseDTO dto) {
			int result = 0;
			
			try {
				openConn();
				sql = "select * from house where house_no = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, dto.getHouse_no());
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					if(dto.getHouse_img1() == null) {
						sql = "update house set house_name = ?, house_category = ?, house_location = ?, house_price = ?, house_content = ?, house_phone = ?, house_person = ?, house_update = sysdate, house_water = ?, house_pool = ?, house_ski = ?, house_food = ?, house_parking = ?, house_grill = ?, house_smoking = ?, house_gym = ?, latitude = ?, longitude = ? where house_no = ?";
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, dto.getHouse_name());
						pstmt.setString(2, dto.getHouse_category());
						pstmt.setString(3, dto.getHouse_location());
						pstmt.setInt(4, dto.getHouse_price());
						pstmt.setString(5, dto.getHouse_content());
						pstmt.setString(6, dto.getHouse_phone());
						pstmt.setInt(7, dto.getHouse_person());
						pstmt.setInt(8, dto.getHouse_water());
						pstmt.setInt(9, dto.getHouse_pool());
						pstmt.setInt(10, dto.getHouse_ski());
						pstmt.setInt(11, dto.getHouse_food());
						pstmt.setInt(12, dto.getHouse_parking());
						pstmt.setInt(13, dto.getHouse_grill());
						pstmt.setInt(14, dto.getHouse_smoking());
						pstmt.setInt(15, dto.getHouse_gym());
						pstmt.setString(16, dto.getLatitude());
						pstmt.setString(17, dto.getLongitude());
						pstmt.setInt(18, dto.getHouse_no());
					} else {	//수정폼 페이지에서 첨부파일을 선택한 경우
						sql = "update house set house_name = ?, house_category = ?, house_location = ?, house_price = ?, house_content = ?, house_phone = ?, house_person = ?, house_img1 = ?, house_img2 = ?, house_img3 = ?, house_update = sysdate, house_water = ?, house_pool = ?, house_ski = ?, house_food = ?, house_parking = ?, house_grill = ?, house_smoking = ?, house_gym = ?, latitude = ?, longitude = ? where house_no = ?";
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, dto.getHouse_name());
						pstmt.setString(2, dto.getHouse_category());
						pstmt.setString(3, dto.getHouse_location());
						pstmt.setInt(4, dto.getHouse_price());
						pstmt.setString(5, dto.getHouse_content());
						pstmt.setString(6, dto.getHouse_phone());
						pstmt.setInt(7, dto.getHouse_person());
						pstmt.setString(8, dto.getHouse_img1());
						pstmt.setString(9, dto.getHouse_img2());
						pstmt.setString(10, dto.getHouse_img3());
						pstmt.setInt(11, dto.getHouse_water());
						pstmt.setInt(12, dto.getHouse_pool());
						pstmt.setInt(13, dto.getHouse_ski());
						pstmt.setInt(14, dto.getHouse_food());
						pstmt.setInt(15, dto.getHouse_parking());
						pstmt.setInt(16, dto.getHouse_grill());
						pstmt.setInt(17, dto.getHouse_smoking());
						pstmt.setInt(18, dto.getHouse_gym());
						pstmt.setString(19, dto.getLatitude());
						pstmt.setString(20, dto.getLongitude());
						pstmt.setInt(21, dto.getHouse_no());
					}
					result = pstmt.executeUpdate();
				} 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closeConn(rs, pstmt, con);
			}
			return result;
		}//modifyUpload() 메서드 end
		
		public List<HouseDTO> getHList(int page, int rowsize) {
			List<HouseDTO> list = new ArrayList<HouseDTO>();
			int startNo = (page*rowsize) - (rowsize - 1);
			int endNo = (page * rowsize);
			
			try {
				openConn();
				sql = "select * from(select row_number() over(order by house_no desc) rnum, b.* from house b) where rnum >= ? and rnum <= ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, startNo);
				pstmt.setInt(2, endNo);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					HouseDTO dto = new HouseDTO();
					dto.setHouse_no(rs.getInt("house_no"));
					dto.setHouse_owner(rs.getString("house_owner"));
					dto.setPmember_code(rs.getLong("pmember_code"));
					dto.setHouse_name(rs.getString("house_name"));
					dto.setHouse_category(rs.getString("house_category"));
					dto.setHouse_location(rs.getString("house_location"));
					dto.setHouse_price(rs.getInt("house_price"));
					dto.setHouse_content(rs.getString("house_content"));
					dto.setHouse_phone(rs.getString("house_phone"));
					dto.setHouse_person(rs.getInt("house_person"));
					dto.setHouse_star(rs.getFloat("house_star"));
					dto.setHouse_update(rs.getString("house_update"));
					dto.setHouse_img1(rs.getString("house_img1"));
					dto.setHouse_img2(rs.getString("house_img2"));
					dto.setHouse_img3(rs.getString("house_img3"));
					dto.setHouse_count(rs.getInt("house_count"));
					dto.setHouse_water(rs.getInt("house_water"));
					dto.setHouse_pool(rs.getInt("house_pool"));
					dto.setHouse_ski(rs.getInt("house_ski"));
					dto.setHouse_food(rs.getInt("house_food"));
					dto.setHouse_parking(rs.getInt("house_parking"));
					dto.setHouse_grill(rs.getInt("house_grill"));
					dto.setHouse_smoking(rs.getInt("house_smoking"));
					dto.setHouse_gym(rs.getInt("house_gym"));
					list.add(dto);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				closeConn(rs, pstmt, con);
			}
			return list;
		}
		
		public int getHouseCount() {
			int count = 0;
			
			try {
				openConn();
				sql = "select count(*) from house";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					count = rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				closeConn(rs, pstmt, con);
			}
			return count;
		}
		
		public HouseDTO selectInfo(String houseNo) {
			openConn();
	    	HouseDTO dto = new HouseDTO();
	       
	        try {
	        	sql = "select * from house where house_no= ?";
	            pstmt = con.prepareStatement(sql);
	            pstmt.setString(1, houseNo);
	            rs = pstmt.executeQuery();
	            if (rs.next()) {            	
	            	dto.setHouse_no(rs.getInt("house_no"));
					dto.setHouse_owner(rs.getString("house_owner"));
					dto.setPmember_code(rs.getLong("pmember_code"));
					dto.setHouse_name(rs.getString("house_name"));
					dto.setHouse_category(rs.getString("house_category"));
					dto.setHouse_location(rs.getString("house_location"));
					dto.setHouse_price(rs.getInt("house_price"));
					dto.setHouse_content(rs.getString("house_content"));
					dto.setHouse_phone(rs.getString("house_phone"));
					dto.setHouse_person(rs.getInt("house_person"));
					dto.setHouse_star(rs.getFloat("house_star"));
					dto.setHouse_update(rs.getString("house_update"));
					dto.setHouse_img1(rs.getString("house_img1"));
					dto.setHouse_img2(rs.getString("house_img2"));
					dto.setHouse_img3(rs.getString("house_img3"));
					dto.setHouse_count(rs.getInt("house_count"));
					dto.setHouse_water(rs.getInt("house_water"));
					dto.setHouse_pool(rs.getInt("house_pool"));
					dto.setHouse_ski(rs.getInt("house_ski"));
					dto.setHouse_food(rs.getInt("house_food"));
					dto.setHouse_parking(rs.getInt("house_parking"));
					dto.setHouse_grill(rs.getInt("house_grill"));
					dto.setHouse_smoking(rs.getInt("house_smoking"));
					dto.setHouse_gym(rs.getInt("house_gym"));
					dto.setLatitude(rs.getString("latitude"));
					dto.setLongitude(rs.getString("longitude"));
	            }
	        } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				closeConn(rs, pstmt, con);
			}
	        return dto;
	    }
		public List<HouseDTO> getFilterList(String cate, int price, int person) {
			openConn();
			List<HouseDTO> list = new ArrayList<HouseDTO>();
			
			try {
				if(cate.equals("선택안함") && price == 0 && person == 0) {
					sql = "select * from house order by house_no desc";
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();
				} else if(cate.equals("선택안함") && price == 0 && person != 0) {
					sql = "select * from house where house_person >= ? order by house_no desc";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, person);
					rs = pstmt.executeQuery();
				} else if(cate.equals("선택안함") && price != 0 && person == 0) {
					sql = "select * from house where house_price <= ? order by house_no desc";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, price);
					rs = pstmt.executeQuery();
				} else if(!cate.equals("선택안함") && person == 0 && person == 0) {
					sql = "select * from house where house_category = ? order by house_no desc";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, cate);
					rs = pstmt.executeQuery();
				} else if(cate.equals("선택안함") && price != 0 && person != 0) {
					sql = "select * from house where house_person >= ? and house_price <= ? order by house_no desc";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, person);
					pstmt.setInt(2, price);
					rs = pstmt.executeQuery();
				} else if(!cate.equals("선택안함") && price != 0 && person == 0) {
					sql = "select * from house where house_category = ? and house_price <= ? order by house_no desc";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, cate);
					pstmt.setInt(2, price);
					rs = pstmt.executeQuery();
				} else if(!cate.equals("선택안함") && price == 0 && person != 0) {
					sql = "select * from house where house_category = ? and house_person >= ? order by house_no desc";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, cate);
					pstmt.setInt(2, person);
					rs = pstmt.executeQuery();
				} else {
					sql = "select * from house where house_category = ? and house_person >= ? and house_price <= ? order by house_no desc";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, cate);
					pstmt.setInt(2, person);
					pstmt.setInt(3, price);
					rs = pstmt.executeQuery();
				}

				while(rs.next()) {
					HouseDTO dto = new HouseDTO();
					dto.setHouse_no(rs.getInt("house_no"));
					dto.setHouse_owner(rs.getString("house_owner"));
					dto.setHouse_name(rs.getString("house_name"));
					dto.setHouse_category(rs.getString("house_category"));
					dto.setHouse_location(rs.getString("house_location"));
					dto.setHouse_price(rs.getInt("house_price"));
					dto.setHouse_content(rs.getString("house_content"));
					dto.setHouse_phone(rs.getString("house_phone"));
					dto.setHouse_person(rs.getInt("house_person"));
					dto.setHouse_star(rs.getFloat("house_star"));
					dto.setHouse_update(rs.getString("house_update"));
					dto.setHouse_img1(rs.getString("house_img1"));
					dto.setHouse_img2(rs.getString("house_img2"));
					dto.setHouse_img3(rs.getString("house_img3"));
					dto.setHouse_count(rs.getInt("house_count"));
					dto.setHouse_water(rs.getInt("house_water"));
					dto.setHouse_pool(rs.getInt("house_pool"));
					dto.setHouse_ski(rs.getInt("house_ski"));
					dto.setHouse_food(rs.getInt("house_food"));
					dto.setHouse_parking(rs.getInt("house_parking"));
					dto.setHouse_grill(rs.getInt("house_grill"));
					dto.setHouse_smoking(rs.getInt("house_smoking"));
					dto.setHouse_gym(rs.getInt("house_gym"));
					list.add(dto);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConn(rs, pstmt, con);
			}
			return list;
		}
		
		public List<HouseDTO> getSearchList(String content) {
			List<HouseDTO> list = new ArrayList<HouseDTO>();
			openConn();
			
			try {
				sql = "select * from house where house_name like ? or house_owner like ? or house_category like ? or house_location like ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+content+"%");
				pstmt.setString(2, "%"+content+"%");
				pstmt.setString(3, "%"+content+"%");
				pstmt.setString(4, "%"+content+"%");
				
				rs = pstmt.executeQuery();
				while(rs.next()) {
					HouseDTO dto = new HouseDTO();
					dto.setHouse_no(rs.getInt("house_no"));
					dto.setHouse_owner(rs.getString("house_owner"));
					dto.setPmember_code(rs.getLong("pmember_code"));
					dto.setHouse_name(rs.getString("house_name"));
					dto.setHouse_category(rs.getString("house_category"));
					dto.setHouse_location(rs.getString("house_location"));
					dto.setHouse_price(rs.getInt("house_price"));
					dto.setHouse_content(rs.getString("house_content"));
					dto.setHouse_phone(rs.getString("house_phone"));
					dto.setHouse_person(rs.getInt("house_person"));
					dto.setHouse_star(rs.getFloat("house_star"));
					dto.setHouse_update(rs.getString("house_update"));
					dto.setHouse_img1(rs.getString("house_img1"));
					dto.setHouse_img2(rs.getString("house_img2"));
					dto.setHouse_img3(rs.getString("house_img3"));
					dto.setHouse_count(rs.getInt("house_count"));
					dto.setHouse_water(rs.getInt("house_water"));
					dto.setHouse_pool(rs.getInt("house_pool"));
					dto.setHouse_ski(rs.getInt("house_ski"));
					dto.setHouse_food(rs.getInt("house_food"));
					dto.setHouse_parking(rs.getInt("house_parking"));
					dto.setHouse_grill(rs.getInt("house_grill"));
					dto.setHouse_smoking(rs.getInt("house_smoking"));
					dto.setHouse_gym(rs.getInt("house_gym"));
					list.add(dto);
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				closeConn(rs, pstmt, con);
			}
			return list;
			
			
		}
}
