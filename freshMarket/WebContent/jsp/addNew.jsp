<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.IOException"%>
<%@ page import="fresh.util.*"%>


<% 
	request.setCharacterEncoding("utf-8") ; 
%>
<div id="addNew" class="tab-pane">
    <div class="addNew_conten">
    	<form action="AddFresh" method="post" enctype="multipart/form-data" accept-charset="utf-8" onsubmit="document.charset='utf-8'">
    		<div>
    			<span class="left_label">选择生鲜类别：</span>
    			<select name="fresh_type">
                    <option value="01">水果</option>
                    <option value="02">蔬菜</option>
                    <option value="03">海鲜</option>
                    <option value="04">畜禽</option>
                    <option value="05">饮品</option>
                    <option value="06">粮油</option>
                    <option value="07">零食</option>
                </select>
    		
    		</div>
    		<div>
    			<span class="left_label">生鲜名：</span>
    			<input type="text" required name="fresh_name" value=""/>
    		</div>
    		
    		<div>
    			<span class="left_label">添加封面图：</span>
    			
                <input id="upload_img" type="file" name="fresh_img" />
                <br/>
                
    	    </div>
   
    		<div>
    			<span class="left_label">产地：</span>
    			<input type="text" name="fresh_production"/>
    		</div>
    		<div>
    			<span class="left_label">简介：</span>
    			<textarea type="text" name="fresh_introduct"></textarea>
    		</div>
    		<div>
    			<span class="left_label">价格：</span>
    			<input type="text" name="fresh_price" value=""/>
    		</div>
    		<div>
    			<span class="left_label">优惠价格：</span>
    			<input type="text" name="fresh_newprice"/>
    		</div>
    		<div>
    			<span class="left_label">库存：</span>
    			<input type="text" name="fresh_num"/>
    		</div>
    		
    		<div>
    		    <button type="submit" class="btn btn-info">保存并上架</button>
    		</div>
    	</form>
    </div>        	
</div>


