package cn.qwx.service.role;

import cn.qwx.entity.Role;

import java.util.List;

public interface RoleService {
    public List<Role> roleList(String roleName);

    public int addRole(Role role);

    public int updateRoleById(Role role);
}


