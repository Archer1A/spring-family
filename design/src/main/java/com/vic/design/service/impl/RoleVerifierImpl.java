package com.vic.design.service.impl;

import com.vic.design.model.Role;
import com.vic.design.service.RoleVerifier;

/**
 * RoleVerifierImpl
 *
 * @author Vic
 * @date 2019/2/24
 */
public class RoleVerifierImpl implements RoleVerifier {

    @Override
    public boolean verifier(Role role) {
        return role != null;
    }
}
