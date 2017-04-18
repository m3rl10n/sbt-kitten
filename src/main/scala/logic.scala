object Logic {
  def matchLikelihood(kitten: Kitten, buyer: BuyerPreferences) = {
    val matches = buyer.attributes.intersect(kitten.attributes).length * 1.0
    if (matches == 0) 0 else matches / buyer.attributes.length 
  }
}
