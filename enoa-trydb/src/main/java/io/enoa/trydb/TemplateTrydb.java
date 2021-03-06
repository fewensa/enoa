/*
 * Copyright (c) 2018, enoa (fewensa@enoa.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.enoa.trydb;

import io.enoa.toolkit.map.Kv;
import io.enoa.trydb.async.TAsyncSupport;
import io.enoa.trydb.async.TemplateEnqueueTrydb;
import io.enoa.trydb.page.Page;
import io.enoa.trydb.tsql.Trysql;
import io.enoa.trydb.tsql.psql.IPSql;
import io.enoa.trydb.tsql.template.TSql;
import io.enoa.trydb.tx.IAtom;
import io.enoa.trydb.tx.TxLevel;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class TemplateTrydb implements _TrydbCommandBase<TemplateTrydb>, _TrydbCommandTemplate, TAsyncSupport<TemplateEnqueueTrydb> {

  private String trysqlName;
  private EnoaTrydb trydb;
  private TrydbConfig config;

  private TemplateTrydb(String trysqlName, EnoaTrydb trydb) {
    this.trysqlName = trysqlName;
    this.trydb = trydb;
    this.config = trydb.config();
  }

  public static TemplateTrydb with(String trysqlName, EnoaTrydb trydb) {
    return new TemplateTrydb(trysqlName, trydb);
  }

  @Override
  public TemplateTrydb conn(Connection conn) {
    return with(this.trysqlName, this.trydb.conn(conn));
  }

  @Override
  public List<Kv> find(String name) {
    TSql tsql = Trysql.tsql(this.config.name(), name);
    return this.trydb.find(tsql.sql());
  }

  @Override
  public List<Kv> find(String name, Object... paras) {
    TSql tsql = Trysql.tsql(this.config.name(), name);
    return this.trydb.find(tsql, paras);
  }

  @Override
  public Kv first(String name) {
    TSql tsql = Trysql.tsql(this.config.name(), name);
    return this.trydb.first(tsql);
  }

  @Override
  public Kv first(String name, Object... paras) {
    TSql tsql = Trysql.tsql(this.config.name(), name);
    return this.trydb.first(tsql.sql(), paras);
  }

  @Override
  public <T> List<T> beans(String name, Class<T> clazz) {
    TSql tsql = Trysql.tsql(this.config.name(), name);
    return this.trydb.beans(tsql.sql(), clazz);
  }

  @Override
  public <T> List<T> beans(String name, Class<T> clazz, Object... paras) {
    TSql tsql = Trysql.tsql(this.config.name(), name);
    return this.trydb.beans(tsql.sql(), clazz, paras);
  }

  @Override
  public <T> T bean(String name, Class<T> clazz) {
    TSql tsql = Trysql.tsql(this.config.name(), name);
    return this.trydb.bean(tsql.sql(), clazz);
  }

  @Override
  public <T> T bean(String name, Class<T> clazz, Object... paras) {
    TSql tsql = Trysql.tsql(this.config.name(), name);
    return this.trydb.bean(tsql.sql(), clazz, paras);
  }

  @Override
  public boolean tx(IAtom atom) {
    return this.trydb.tx(atom);
  }

  @Override
  public boolean tx(TxLevel level, IAtom atom) {
    return this.trydb.tx(level, atom);
  }

  @Override
  public int update(String name) {
    TSql tsql = Trysql.tsql(this.config.name(), name);
    return this.trydb.update(tsql.sql());
  }

  @Override
  public int update(String name, Object... paras) {
    TSql tsql = Trysql.tsql(this.config.name(), name);
    return this.trydb.update(tsql.sql(), paras);
  }

  @Override
  public List<Kv> find(String name, Map<String, ?> para) {
    TSql tsql = Trysql.tsql(this.config.name(), name, para);
    return this.trydb.find(tsql.sql(), tsql.paras());
  }

  @Override
  public Kv first(String name, Map<String, ?> para) {
    TSql tsql = Trysql.tsql(this.config.name(), name, para);
    return this.trydb.first(tsql.sql(), tsql.paras());
  }

  @Override
  public <T> List<T> beans(String name, Class<T> clazz, Map<String, ?> para) {
    TSql tsql = Trysql.tsql(this.config.name(), name, para);
    return this.trydb.beans(tsql.sql(), clazz, tsql.paras());
  }

  @Override
  public <T> T bean(String name, Class<T> clazz, Map<String, ?> para) {
    TSql tsql = Trysql.tsql(this.config.name(), name, para);
    return this.trydb.bean(tsql.sql(), clazz, tsql.paras());
  }

  @Override
  public int update(String name, Map<String, ?> para) {
    TSql tsql = Trysql.tsql(this.config.name(), name, para);
    return this.trydb.update(tsql.sql(), tsql.paras());
  }

  @Override
  public Page<Kv> pagekv(IPSql ipsql, int pn, int ps, String name) {
    TSql tsql = Trysql.tsql(this.config.name(), name);
    return this.trydb.pagekv(ipsql, pn, ps, tsql, tsql.paras());
  }

  @Override
  public Page<Kv> pagekv(IPSql ipsql, int pn, int ps, String name, Object... paras) {
    TSql tsql = Trysql.tsql(this.config.name(), name);
    return this.trydb.pagekv(ipsql, pn, ps, tsql.sql(), paras);
  }

  @Override
  public Page<Kv> pagekv(IPSql ipsql, int pn, int ps, String name, Map<String, ?> para) {
    TSql tsql = Trysql.tsql(this.config.name(), name, para);
    return this.trydb.pagekv(ipsql, pn, ps, tsql.sql(), tsql.paras());
  }

  @Override
  public <T> Page<T> page(IPSql ipsql, int pn, int ps, String name, Class<T> clazz) {
    TSql tsql = Trysql.tsql(this.config.name(), name);
    return this.trydb.page(ipsql, pn, ps, tsql.sql(), clazz, tsql.paras());
  }

  @Override
  public <T> Page<T> page(IPSql ipsql, int pn, int ps, String name, Class<T> clazz, Object... paras) {
    TSql tsql = Trysql.tsql(this.config.name(), name);
    return this.trydb.page(ipsql, pn, ps, tsql.sql(), clazz, paras);
  }

  @Override
  public <T> Page<T> page(IPSql ipsql, int pn, int ps, String name, Class<T> clazz, Map<String, ?> para) {
    TSql tsql = Trysql.tsql(this.config.name(), name, para);
    return this.trydb.page(ipsql, pn, ps, tsql.sql(), clazz, tsql.paras());
  }

  @Override
  public Page<Kv> pagekv(int pn, int ps, String name) {
    return this.pagekv(IPSql.sqlfrom(), pn, ps, name);
  }

  @Override
  public Page<Kv> pagekv(int pn, int ps, String name, Object... paras) {
    return this.pagekv(IPSql.sqlfrom(), pn, ps, name, paras);
  }

  @Override
  public <T> Page<T> page(int pn, int ps, String name, Class<T> clazz) {
    return this.page(IPSql.sqlfrom(), pn, ps, name, clazz);
  }

  @Override
  public <T> Page<T> page(int pn, int ps, String name, Class<T> clazz, Object... paras) {
    return this.page(IPSql.sqlfrom(), pn, ps, name, clazz, paras);
  }

  @Override
  public TemplateEnqueueTrydb async() {
    return new TemplateEnqueueTrydb(this);
  }

}
