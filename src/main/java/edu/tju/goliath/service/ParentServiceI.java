package edu.tju.goliath.service;

import java.util.List;

import edu.tju.goliath.entity.Parent;

public interface ParentServiceI {
    int deleteParentById(Integer parentid);

    int addParent(Parent record);

    int addParentSelective(Parent record);

    Parent getParentById(Integer parentid);
    
    Parent getParentByName(String parentname);
    
    Parent getParentByEmail(String parentemail);

    int updateParentByIdSelective(Parent record);

    int updateParentById(Parent record);
    
    List<Parent> getAllParent();

}
