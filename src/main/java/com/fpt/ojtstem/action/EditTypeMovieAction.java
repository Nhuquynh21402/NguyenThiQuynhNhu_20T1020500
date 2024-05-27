package com.fpt.ojtstem.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.fpt.ojtstem.dao.TypeMovieDao;
import com.fpt.ojtstem.model.TypeMovie;
import com.fpt.ojtstem.util.StringUtil;
import com.opensymphony.xwork2.ActionSupport;

import net.bytebuddy.implementation.bytecode.Throw;

public class EditTypeMovieAction extends ActionSupport implements SessionAware{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private String id;
    private TypeMovie  type=null;
    private String typeId;
    private String idTheloai;
    private String tenTheloai;
    private Map<String, Object> sessionID;
	List<TypeMovie> listType = new ArrayList<TypeMovie>();
    // Getter và Setter cho request

    @Override
    public String execute() throws Exception{
    TypeMovieDao tDao=new TypeMovieDao();
    type=tDao.findType(id);
        return SUCCESS;
    }
    
  public String updateTypeMovie() {
    	
    	try {
    		if(!sessionID.containsKey("typeMovie")) {
    			sessionID.put("typeMovie", idTheloai);
    		}
    		
    		TypeMovieDao typeDao = new TypeMovieDao();
			this.listType = typeDao.getAll();
    		if(StringUtil.isNullOrEmpty(tenTheloai)) {
    			addActionError("Không được để trống tên thể loại phim.!!");
    			return ERROR;
    		}else if(tenTheloai.matches("^[+-]?[\\d]*[.]?[\\d]*$")){
    			addActionError("Tên thể loại không được là 1 số!!");
    			return ERROR;
    			
    		}else if(!tenTheloai.matches("^[\\p{L}\\s]+$")) {
    			addActionError("Tên thể loại chỉ chứa kí tự chữ cái và khoảng trắng!");
    			return ERROR;
    		}else if(tenTheloai.length()>50) {
    			addActionError("Tên thể loại không được dài quá 50 kí tự!");
    			return ERROR;
    		}
    		else  if ( tenTheloai.length()>7 && !StringUtil.containsWhitespace(tenTheloai)) {
	        	
	        	 addActionError("Tên thể loại phim không đúng");
		            return ERROR;
	        }else {
    			if (!checkName(tenTheloai.trim())) {
    				
    				TypeMovie t=new TypeMovie(idTheloai, tenTheloai);
    	            typeDao.updateTypeMovie(t);
    	            return "Update";
    			}else {
    			     String ten=typeDao.findType(idTheloai).getTypeMovieName();
    				if(tenTheloai.equals(ten)) {
    					TypeMovie t=new TypeMovie(idTheloai, tenTheloai);
        	            typeDao.updateTypeMovie(t);
        	            sessionID.clear();
        	            return "Update";
        	            
    				}
    				else {
    					addActionError("Tên thể loại phim đã được sử dụng.!!");
    					return ERROR;
    					
    				}
    				
    				
    				
    			}
    		}

		} catch (Exception e) {
			return ERROR;
		}
  	
    	}
  public String delete() {
	  try {
		  TypeMovieDao typeDao = new TypeMovieDao();
		  typeDao.deleteTypeMovie(typeId);
		  return "delete";
	  }catch (Exception e) {
		return ERROR;
	}
  }
  private boolean checkName(String name) {
		for (TypeMovie type : listType) {
			if (type.getTypeMovieName().equals(name) ) {
				return true;
			}
		}
		return false;
	}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public TypeMovie getType() {
	return type;
}

public void setType(TypeMovie type) {
	this.type = type;
}

public String getTypeId() {
	return typeId;
}

public void setTypeId(String typeId) {
	this.typeId = typeId;
}

public String getIdTheloai() {
	return idTheloai;
}

public void setIdTheloai(String idTheloai) {
	this.idTheloai = idTheloai;
}

public String getTenTheloai() {
	return tenTheloai;
}

public void setTenTheloai(String tenTheloai) {
	this.tenTheloai = tenTheloai;
}

public List<TypeMovie> getListType() {
	return listType;
}

public void setListType(List<TypeMovie> listType) {
	this.listType = listType;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}

@Override
public void setSession(Map<String, Object> session) {
	this.sessionID=session;
	
}

public Map<String, Object> getSessionID() {
	return sessionID;
}

public void setSessionID(Map<String, Object> sessionID) {
	this.sessionID = sessionID;
}


}