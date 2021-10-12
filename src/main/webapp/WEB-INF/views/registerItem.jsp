<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/adminHeader.jsp"%>
<main>
	<div id="contents">
		<h2 class="contentsTitle">회원가입</h2>
		<form method="POST" action="RegisterItem.do" id="join" class="form"
			name="signUp" enctype="multipart/form-data">
			<table border="1" class="tdLeft">
				<cols>
				<col style="width: 200px">
				<col style="width: 600px">
				</cols>
				<tbody>
					<tr>
						<th>PRODUCTNUMBER<span>*</span></th>
						<td><input type="text" name="productNumber" placeholder="productNumber"></td>
					</tr>
					<tr>
						<th>CATEGORY_CODE <span>*</span></th>
						<td><input type="text" name="categoryCode" placeholder="categoryCode"></td>
					</tr>
					<tr>
						<th>PRODUCT_NAME <span>*</span></th>
						<td><input type="text" name="productName" placeholder="categoryCode"></td>
					</tr>
					<tr>
						<th>PRODUCT_PRICE</th>
						<td><input type="text" name="productPrice"></td>
					</tr>
					<tr>
						<th>PRODUCT_STOCK</th>
						<td><input type="text" name="productStock"></td>
					</tr>
					<tr>
						<th>PRODUCT_DESC</th>
						<td><input type="text" name="productDesc"></td>
					</tr>
					<tr>
						<th>이미지<span>*</span></th>
						<td><input type="file" name="multipartProfile"></td>
					</tr>
				</tbody>
			</table>
			<div class="btns center">
				<input type="submit" value="회원가입" onClick="return signCheck();">
			</div>
		</form>




	</div>
</main>
<!-- contents end -->





<%@ include file="include/footer.jsp"%>
