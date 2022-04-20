package com.mycom.mybatis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycom.mybatis.dto.EmpDto;

@Repository
public class DBDaoImpl implements DBDao {

	@Autowired
	DataSource dataSource;

	@Override
	public EmpDto empDetail(int employeeId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		EmpDto dto = null;
		try {
			con = dataSource.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT employeeId, first_name, last_name, email, hiredate ");
			sb.append("  FROM emp ");
			sb.append(" WHERE employeeId = ? ");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, employeeId);
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new EmpDto();
				dto.setEmployeeId(rs.getInt("employeeId"));
				dto.setFirstName(rs.getString("first_name"));
				dto.setLastName(rs.getString("last_name"));
				dto.setEmail(rs.getString("email"));
				dto.setHireDate(rs.getString("hiredate"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return dto;
	}

	@Override
	public List<EmpDto> empList() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<EmpDto> list = new ArrayList<>();
		try {
			con = dataSource.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT employeeId, first_name, last_name, email, hiredate ");
			sb.append("  FROM emp ");
			
			pstmt = con.prepareStatement(sb.toString());
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				EmpDto dto = new EmpDto();
				dto.setEmployeeId(rs.getInt("employeeId"));
				dto.setFirstName(rs.getString("first_name"));
				dto.setLastName(rs.getString("last_name"));
				dto.setEmail(rs.getString("email"));
				dto.setHireDate(rs.getString("hiredate"));
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	@Override
	public int empInsert(EmpDto dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int ret = -1;
		try {
			con = dataSource.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO emp (employeeId, first_name, last_name, email, hiredate) ");
			sb.append(" VALUES (?, ?, ?, ?, ?) ");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, dto.getEmployeeId());
			pstmt.setString(2, dto.getFirstName());
			pstmt.setString(3, dto.getLastName());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getHireDate());
			
			ret = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return ret;
	}

	@Override
	public int empUpdate(EmpDto dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int ret = -1;
		try {
			con = dataSource.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE emp ");
			sb.append("   SET first_name = ?, last_name = ?, email = ?, hiredate = ? ");
			sb.append(" WHERE employeeId = ? ");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, dto.getFirstName());
			pstmt.setString(2, dto.getLastName());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getHireDate());
			pstmt.setInt(5, dto.getEmployeeId());
			
			ret = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return ret;
	}

	@Override
	public int empDelete(int employeeId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int ret = -1;
		try {
			con = dataSource.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("DELETE FROM emp WHERE employeeId = ? ");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, employeeId);
			
			ret = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return ret;
	}

}
