
package com.bank.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.bank.services package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Charge_QNAME = new QName("http://services.bank.com/", "charge");
    private final static QName _ChargeResponse_QNAME = new QName("http://services.bank.com/", "chargeResponse");
    private final static QName _GetAmountResponse_QNAME = new QName("http://services.bank.com/", "getAmountResponse");
    private final static QName _GetAllCreditCardResponse_QNAME = new QName("http://services.bank.com/", "getAllCreditCardResponse");
    private final static QName _IsExists_QNAME = new QName("http://services.bank.com/", "isExists");
    private final static QName _IsValidResponse_QNAME = new QName("http://services.bank.com/", "isValidResponse");
    private final static QName _GetAllCreditCard_QNAME = new QName("http://services.bank.com/", "getAllCreditCard");
    private final static QName _GetAmount_QNAME = new QName("http://services.bank.com/", "getAmount");
    private final static QName _IsExistsResponse_QNAME = new QName("http://services.bank.com/", "isExistsResponse");
    private final static QName _IsValid_QNAME = new QName("http://services.bank.com/", "isValid");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.bank.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ChargeResponse }
     * 
     */
    public ChargeResponse createChargeResponse() {
        return new ChargeResponse();
    }

    /**
     * Create an instance of {@link Charge }
     * 
     */
    public Charge createCharge() {
        return new Charge();
    }

    /**
     * Create an instance of {@link GetAmountResponse }
     * 
     */
    public GetAmountResponse createGetAmountResponse() {
        return new GetAmountResponse();
    }

    /**
     * Create an instance of {@link IsValidResponse }
     * 
     */
    public IsValidResponse createIsValidResponse() {
        return new IsValidResponse();
    }

    /**
     * Create an instance of {@link GetAllCreditCardResponse }
     * 
     */
    public GetAllCreditCardResponse createGetAllCreditCardResponse() {
        return new GetAllCreditCardResponse();
    }

    /**
     * Create an instance of {@link IsExists }
     * 
     */
    public IsExists createIsExists() {
        return new IsExists();
    }

    /**
     * Create an instance of {@link IsValid }
     * 
     */
    public IsValid createIsValid() {
        return new IsValid();
    }

    /**
     * Create an instance of {@link IsExistsResponse }
     * 
     */
    public IsExistsResponse createIsExistsResponse() {
        return new IsExistsResponse();
    }

    /**
     * Create an instance of {@link GetAllCreditCard }
     * 
     */
    public GetAllCreditCard createGetAllCreditCard() {
        return new GetAllCreditCard();
    }

    /**
     * Create an instance of {@link GetAmount }
     * 
     */
    public GetAmount createGetAmount() {
        return new GetAmount();
    }

    /**
     * Create an instance of {@link CreditCard }
     * 
     */
    public CreditCard createCreditCard() {
        return new CreditCard();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Charge }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bank.com/", name = "charge")
    public JAXBElement<Charge> createCharge(Charge value) {
        return new JAXBElement<Charge>(_Charge_QNAME, Charge.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChargeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bank.com/", name = "chargeResponse")
    public JAXBElement<ChargeResponse> createChargeResponse(ChargeResponse value) {
        return new JAXBElement<ChargeResponse>(_ChargeResponse_QNAME, ChargeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAmountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bank.com/", name = "getAmountResponse")
    public JAXBElement<GetAmountResponse> createGetAmountResponse(GetAmountResponse value) {
        return new JAXBElement<GetAmountResponse>(_GetAmountResponse_QNAME, GetAmountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCreditCardResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bank.com/", name = "getAllCreditCardResponse")
    public JAXBElement<GetAllCreditCardResponse> createGetAllCreditCardResponse(GetAllCreditCardResponse value) {
        return new JAXBElement<GetAllCreditCardResponse>(_GetAllCreditCardResponse_QNAME, GetAllCreditCardResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsExists }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bank.com/", name = "isExists")
    public JAXBElement<IsExists> createIsExists(IsExists value) {
        return new JAXBElement<IsExists>(_IsExists_QNAME, IsExists.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsValidResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bank.com/", name = "isValidResponse")
    public JAXBElement<IsValidResponse> createIsValidResponse(IsValidResponse value) {
        return new JAXBElement<IsValidResponse>(_IsValidResponse_QNAME, IsValidResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCreditCard }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bank.com/", name = "getAllCreditCard")
    public JAXBElement<GetAllCreditCard> createGetAllCreditCard(GetAllCreditCard value) {
        return new JAXBElement<GetAllCreditCard>(_GetAllCreditCard_QNAME, GetAllCreditCard.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAmount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bank.com/", name = "getAmount")
    public JAXBElement<GetAmount> createGetAmount(GetAmount value) {
        return new JAXBElement<GetAmount>(_GetAmount_QNAME, GetAmount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsExistsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bank.com/", name = "isExistsResponse")
    public JAXBElement<IsExistsResponse> createIsExistsResponse(IsExistsResponse value) {
        return new JAXBElement<IsExistsResponse>(_IsExistsResponse_QNAME, IsExistsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsValid }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.bank.com/", name = "isValid")
    public JAXBElement<IsValid> createIsValid(IsValid value) {
        return new JAXBElement<IsValid>(_IsValid_QNAME, IsValid.class, null, value);
    }

}
