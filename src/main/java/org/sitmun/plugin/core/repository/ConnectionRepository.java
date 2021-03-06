package org.sitmun.plugin.core.repository;

import java.math.BigInteger;
import java.util.Optional;
import org.sitmun.plugin.core.domain.Connection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;

@RepositoryRestResource(collectionResourceRel = "connections", path = "connections")
public interface ConnectionRepository extends CrudRepository<Connection, BigInteger> {

  @Override
  @PreAuthorize("hasPermission(#entity, 'administration') or hasPermission(#entity, 'write')")
  <S extends Connection> S save(@P("entity") S entity);

  @Override
  @PreAuthorize("hasPermission(#entity, 'administration') or hasPermission(#entity,  'delete')")
  void delete(@P("entity") Connection entity);

  @Override
  @PreAuthorize("hasPermission(#entityId, 'org.sitmun.plugin.core.domain.Connection','administration') or hasPermission(#entityId, 'org.sitmun.plugin.core.domain.Connection', 'delete')")
  void deleteById(@P("entityId") BigInteger entityId);

  @Override
  @PostFilter("hasPermission(filterObject, 'administration') or hasPermission(filterObject, 'read')")
  Iterable<Connection> findAll();

  @Override
  @PreAuthorize("hasPermission(#entityId, 'org.sitmun.plugin.core.domain.Connection','administration') or hasPermission(#entityId, 'org.sitmun.plugin.core.domain.Connection', 'read')")
  Optional<Connection> findById(@P("entityId") BigInteger entityId);

}