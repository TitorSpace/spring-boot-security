package spring_boot_security.common.application.mediator;

//T is in charge of example of use case of deleting one product. A request.
//R refers to our response
public interface RequestHandler<T extends Request<R>, R> {

    R handle(T request);

    Class<T> getRequestType();

}
