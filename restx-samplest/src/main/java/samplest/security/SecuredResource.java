package samplest.security;

import restx.annotations.GET;
import restx.annotations.RestxResource;
import restx.factory.Component;
import restx.security.RestxSession;
import restx.security.RolesAllowed;

/**
 * Date: 12/12/13
 * Time: 19:10
 */
@RestxResource @Component
public class SecuredResource {
    @GET("/security/user")
    public String getUser() {
        return RestxSession.current().getPrincipal().get().getName();
    }

    @GET("/security/{companyId}/{subCompanyId}")
    @RolesAllowed(CompanyAndSubCompanyRoles.Constants.CAN_EDIT_COMPANY__$COMPANY_ID__SUBCOMPANY__$SUBCOMPANY_ID__)
    public String editSubCompany(String companyId, String subCompanyId){
        return RestxSession.current().getPrincipal().get().getName();
    }
}
