package org.sitmun.plugin.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * Tree node.
 */
@Entity
@Table(name = "STM_TREE_NOD")
public class TreeNode {

  /**
   * Unique identifier.
   */
  @TableGenerator(
      name = "STM_ARBOLNOD_GEN",
      table = "STM_CODIGOS",
      pkColumnName = "GEN_CODIGO",
      valueColumnName = "GEN_VALOR",
      pkColumnValue = "TNO_ID",
      allocationSize = 1)
  @Id
  @GeneratedValue(strategy = GenerationType.TABLE, generator = "STM_ARBOLNOD_GEN")
  @Column(name = "TNO_ID", precision = 11)
  private BigInteger id;

  /**
   * Parent node.
   */
  @JoinColumn(name = "TNO_PARENTID", foreignKey = @ForeignKey(name = "STM_ARN_FK_ARN"))
  @ManyToOne
  @JsonIgnore
  private TreeNode parent;

  /**
   * Name.
   */
  @Column(name = "TNO_NAME", length = 80)
  private String name;

  /**
   * Description.
   */
  @Column(name = "TNO_ABSTRACT", length = 250)
  private String description;

  /**
   * Tooltip text.
   */
  @Column(name = "TNO_TOOLTIP", length = 100)
  private String tooltip;

  /**
   * Enabled by default.
   */
  @Column(name = "TNO_ACTIVE")
  private Boolean active;

  /**
   * Radio button type (only if the node is a folder).
   */
  @Column(name = "TNO_RADIO")
  private Boolean radio;

  /**
   * Order of the node within the tree.
   */
  @Column(name = "TNO_ORDER", precision = 6)
  private BigInteger orden;

  /**
   * URL to metadata.
   */
  @Column(name = "TNO_METAURL", length = 250)
  private String metadataURL;

  /**
   * URL to downloadable (zip) dataset.
   */
  @Column(name = "TNO_DATAURL", length = 4000)
  private String datasetURL;

  /**
   * Enable GetMap Filter (if available).
   */
  @Column(name = "TNO_FILTER_GM")
  private Boolean filterGetMap;

  /**
   * Enable GetFeatureInfo Filter (if available).
   */
  @Column(name = "TNO_FILTER_GFI")
  private Boolean filterGetFeatureInfo;

  /**
   * Enable GetFeatureInfo (if available).
   */
  @Column(name = "TNO_QUERYACT")
  private Boolean queryableActive;

  /**
   * Enable Selectable Filter (if available).
   */
  @Column(name = "TNO_FILTER_SE")
  private Boolean filterSelectable;

  /**
   * Tree.
   */
  @JoinColumn(name = "TNO_TREEID", foreignKey = @ForeignKey(name = "STM_ARN_FK_ARB"))
  @ManyToOne
  private Tree tree;

  /**
   * Cartography associated to this node.
   */
  @JoinColumn(name = "TNO_GIID", foreignKey = @ForeignKey(name = "STM_ARN_FK_CAR"))
  @ManyToOne
  private Cartography cartography;

  public BigInteger getId() {
    return id;
  }

  public void setId(BigInteger id) {
    this.id = id;
  }

  public TreeNode getParent() {
    return parent;
  }

  public void setParent(TreeNode parent) {
    this.parent = parent;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getTooltip() {
    return tooltip;
  }

  public void setTooltip(String tooltip) {
    this.tooltip = tooltip;
  }

  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public Boolean getRadio() {
    return radio;
  }

  public void setRadio(Boolean radio) {
    this.radio = radio;
  }

  public BigInteger getOrden() {
    return orden;
  }

  public void setOrden(BigInteger orden) {
    this.orden = orden;
  }

  public String getMetadataURL() {
    return metadataURL;
  }

  public void setMetadataURL(String metadataURL) {
    this.metadataURL = metadataURL;
  }

  public String getDatasetURL() {
    return datasetURL;
  }

  public void setDatasetURL(String datasetURL) {
    this.datasetURL = datasetURL;
  }

  public Boolean getFilterGetMap() {
    return filterGetMap;
  }

  public void setFilterGetMap(Boolean filterGetMap) {
    this.filterGetMap = filterGetMap;
  }

  public Boolean getFilterGetFeatureInfo() {
    return filterGetFeatureInfo;
  }

  public void setFilterGetFeatureInfo(Boolean filterGetFeatureInfo) {
    this.filterGetFeatureInfo = filterGetFeatureInfo;
  }

  public Boolean getQueryableActive() {
    return queryableActive;
  }

  public void setQueryableActive(Boolean queryableActive) {
    this.queryableActive = queryableActive;
  }

  public Boolean getFilterSelectable() {
    return filterSelectable;
  }

  public void setFilterSelectable(Boolean filterSelectable) {
    this.filterSelectable = filterSelectable;
  }

  public Tree getTree() {
    return tree;
  }

  public void setTree(Tree tree) {
    this.tree = tree;
  }

  public Cartography getCartography() {
    return cartography;
  }

  public void setCartography(Cartography cartography) {
    this.cartography = cartography;
  }
}
