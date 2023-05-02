const postToStripe = async (payment) => {
  const req = {
    method: "POST",
    headers: {
      Authorization: "Bearer sk_test_51LKnT3HQFzhXv47eB7VLHnT24DGSwcB1HUjTXOXWjJn9dsz3fydRinBstObtxjhwZrsifaof6TF7vQzzPDzt7AkQ00D8RtnyVz",
      "Content-Type": "application/x-www-form-urlencoded"
    },
    body: new URLSearchParams({
      amount: payment.amount,
      currency: payment.currency,
      source: payment.source
    }),
  };
  try {
    const fetchResponse = await fetch("https://api.stripe.com/v1/charges", req)
    const data = await fetchResponse.json();
    return data;
  } catch (error) {
    return error
  }
}

module.exports = postToStripe



