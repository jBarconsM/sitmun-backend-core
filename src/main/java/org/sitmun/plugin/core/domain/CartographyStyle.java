package org.sitmun.plugin.core.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;

/**
 * Geographic Information style.
 */
@Entity
@Table(name = "STM_STY_GI")
public class CartographyStyle {

  /**
   * Unique identifier.
   */
  @TableGenerator(
      name = "STM_STY_GI_GEN",
      table = "STM_CODIGOS",
      pkColumnName = "GEN_CODIGO",
      valueColumnName = "GEN_VALOR",
      pkColumnValue = "SGI_ID",
      allocationSize = 1)
  @Id
  @GeneratedValue(strategy = GenerationType.TABLE, generator = "STM_STY_GI_GEN")
  @Column(name = "SGI_ID")
  private Integer id;

  /**
   * Style name.
   */
  @NotNull
  @Column(name = "SGI_NAME", length = 80)
  private String name;

  /**
   * Style title.
   */
  @Column(name = "SGI_TITLE", length = 250)
  private String title;

  /**
   * Style abstract.
   */
  @Column(name = "SGI_ABSTRACT", length = 250)
  private String description;

  /**
   * Style legend.
   */
  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "width", column = @Column(name = "SGI_LURL_WIDTH")),
      @AttributeOverride(name = "height", column = @Column(name = "SGI_LURL_HEIGHT")),
      @AttributeOverride(name = "format", column = @Column(name = "SGI_LURL_FORMAT")),
      @AttributeOverride(name = "onlineResource", column = @Column(name = "SGI_LURL_URL")),
  })
  private LegendURL legendURL;

  /**
   * Cartography that owns the style.
   */
  @ManyToOne
  @JoinColumn(name = "SGI_GIID")
  @NotNull
  private Cartography cartography;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LegendURL getLegendURL() {
    return legendURL;
  }

  public void setLegendURL(LegendURL legendURL) {
    this.legendURL = legendURL;
  }

  public Cartography getCartography() {
    return cartography;
  }

  public void setCartography(Cartography cartography) {
    this.cartography = cartography;
  }
}

