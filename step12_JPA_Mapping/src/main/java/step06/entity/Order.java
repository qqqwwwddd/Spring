package step06.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
//@Entity(name = "\"order\"")
@Entity(name = "order_data")
public class Order {

	// 테이블 안에서는 각각이 id 가지고 있는게 좋음 !
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Long id;

	@ManyToOne
//	@JoinColumn(name = "member_id")
	@JoinColumn(name = "member_id", foreignKey = @ForeignKey(foreignKeyDefinition = "FOREIGN KEY (member_id) references member (member_id) ON DELETE SET NULL"))
	private Member member;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

}
