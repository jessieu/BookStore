package com.bookstore.entity;
// Generated Jul 10, 2020 9:56:41 AM by Hibernate Tools 5.2.12.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * BookOrder generated by hbm2java
 */
@Entity
@Table(name = "book_order", catalog = "bookstoredb")
@NamedQueries({
	@NamedQuery(name = "BookOrder.findAll", query = "SELECT bo FROM BookOrder bo ORDER BY bo.orderDate DESC"),
	@NamedQuery(name = "BookOrder.countAll", query = "SELECT COUNT(*) FROM BookOrder bo"),
	@NamedQuery(name="BookOrder.findByCustomer", query="SELECT bo FROM BookOrder bo WHERE bo.customer.customerId = :customerId ORDER BY bo.orderDate DESC"),
	@NamedQuery(name="BookOrder.findByIdAdCustomer", 
				query="SELECT bo FROM BookOrder bo WHERE bo.orderId = :orderId AND bo.customer.customerId = :customerId")	
})
public class BookOrder implements java.io.Serializable {

	private Integer orderId;
	private Customer customer;
	private Date orderDate;
	private String addressLine1;
	private String addressLine2;
	private String firstname;
	private String lastname;
	private String city;
	private String state;
	private String country;
	private String recipientPhone;
	private String paymentMethod;
	
	private float total;
	private float subtotal;
	private float shippingFee;
	private float tax;
	private String status;
	private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>(0);

	public BookOrder() {
	}
	
	

	public BookOrder(Customer customer, Date orderDate, String addressLine1, String addressLine2, String recipientName,
			String recipientPhone, String paymentMethod, float total, String status) {
		this.customer = customer;
		this.orderDate = orderDate;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.firstname = recipientName;
		this.recipientPhone = recipientPhone;
		this.paymentMethod = paymentMethod;
		this.total = total;
		this.status = status;
	}

	public BookOrder(Customer customer, Date orderDate, String addressLine1, String addressLine2, String recipientName,
			String recipientPhone, String paymentMethod, float total, String status, Set<OrderDetail> orderDetails) {
		this(customer, orderDate, addressLine1, addressLine2, recipientName, recipientPhone, paymentMethod, total, status);
		this.orderDetails = orderDetails;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "order_id", unique = true, nullable = false)
	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id", nullable = false)
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "order_date", nullable = false, length = 19)
	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	@Column(name = "r_address_line1", nullable = false, length = 256)
	public String getAddressLine1() {
		return addressLine1;
	}


	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}


	@Column(name = "r_address_line2", nullable = false, length = 256)
	public String getAddressLine2() {
		return addressLine2;
	}



	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}


	@Column(name = "first_name", nullable = false, length = 30)
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	@Column(name = "last_name", nullable = false, length = 30)
	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	@Column(name = "recipient_phone", nullable = false, length = 15)
	public String getRecipientPhone() {
		return this.recipientPhone;
	}

	public void setRecipientPhone(String recipientPhone) {
		this.recipientPhone = recipientPhone;
	}

	@Column(name = "payment_method", nullable = false, length = 20)
	public String getPaymentMethod() {
		return this.paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	@Column(name = "total", nullable = false, precision = 12, scale = 0)
	public float getTotal() {
		return this.total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	@Column(name = "status", nullable = false, length = 20)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "bookOrder", cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
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
		BookOrder other = (BookOrder) obj;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}
	
	@Transient
	public int getBookCopies() {
		int total = 0;
		for (OrderDetail orderDetail : orderDetails) {
			total += orderDetail.getQuantity();
		}
		
		return total;
	}

}
