/*
 * Copyright 2021 Red Hat
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.apicurio.multitenant.client;

import io.apicurio.multitenant.api.datamodel.NewApicurioTenantRequest;
import io.apicurio.multitenant.api.datamodel.ApicurioTenant;
import io.apicurio.multitenant.api.datamodel.ApicurioTenantList;
import io.apicurio.multitenant.api.datamodel.SortBy;
import io.apicurio.multitenant.api.datamodel.SortOrder;
import io.apicurio.multitenant.api.datamodel.TenantStatusValue;
import io.apicurio.multitenant.api.datamodel.UpdateApicurioTenantRequest;

/**
 * @author Fabian Martinez
 */
public interface TenantManagerClient {

    /**
     * List tenants using the provided search parameters.
     * All parameters can be null, the server will use default values
     */
    public ApicurioTenantList listTenants(TenantStatusValue status, Integer offset, Integer limit, SortOrder order, SortBy orderby);

    /**
     * Creates a new tenant
     */
    public ApicurioTenant createTenant(NewApicurioTenantRequest tenantRequest);

    /**
     * Updates some tenant fields.
     * If some field is not provided it won't be updated.
     */
    public void updateTenant(String tenantId, UpdateApicurioTenantRequest updateRequest);

    /**
     * Retrieves the tenant information by tenantId
     */
    public ApicurioTenant getTenant(String tenantId);

    /**
     * Updates the tenant status to {@link TenantStatusValue#TO_BE_DELETED}
     */
    public void deleteTenant(String tenantId);

}
