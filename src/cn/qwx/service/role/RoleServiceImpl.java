package cn.qwx.service.role;

import cn.qwx.dao.role.RoleMapper;
import cn.qwx.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    public void setRoleMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Override
    public List<Role> roleList(String roleName) {
        return roleMapper.roleList(roleName);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public int addRole(Role role) {
        return roleMapper.addRole(role);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public int updateRoleById(Role role) {
        return roleMapper.updateRoleById(role);
    }
}
