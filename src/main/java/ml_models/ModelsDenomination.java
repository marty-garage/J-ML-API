package ml_models;

public enum ModelsDenomination {

 NEAT("neat","Neat_population",4), FEED_F("twp","Simple_trainig",4);
  
  private String _name;
  private String _method;
  private int[] _option;

  ModelsDenomination(String name,String method,int... option) {
    _name = name;
    _method = method;
    _option = option;
  }

  String getName() {
    return _name;
  }
  String getMethod() {
	  return _method;
  }
  int[] getOtpion() {
	  return _option;
  }

}