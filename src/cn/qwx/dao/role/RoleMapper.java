package cn.qwx.dao.role;

import cn.qwx.entity.Role;

import java.util.List;

public interface RoleMapper {

    /**
     * 根据角色名称模糊查询供应表信息
     * @param roleName
     * @return
     */
    public List<Role> roleList(String roleName);

    /**
     * 添加角色信息
     * @param role
     * @return
     */
    public int addRole(Role role);

    /**
     * 修改角色信息
     * @param role
     * @return
     */
    public int updateRoleById(Role role);

}


