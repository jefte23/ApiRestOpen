package br.com.bb.ditec.gesit.capacidade.api.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

@SuppressWarnings("hiding")
@MappedSuperclass
//http://www.universidadejava.com.br/materiais/jpa-sequence/
public abstract class AbstractModel<Long extends Serializable> implements Serializable {

    private static final long serialVersionUID = -6323358535657100144L;
    
	@Id 
	@Column(name="ID")
	@SequenceGenerator(name = "ID_SEQ", sequenceName = "TB_RECOMENDACAO_TECNICA_ID_SEQ", initialValue = 1, allocationSize = 1) 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQ")
	private Long id;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AbstractModel<?> other = (AbstractModel<?>) obj;
        if (id == null) {
            return other.id == null;
        } else return id.equals(other.id);
    }

}
