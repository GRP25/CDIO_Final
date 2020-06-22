import json, requests

class Commodity:
    def setJson(self, name, _id):
        self.json = {
            "commodity_Name": name,
            "commodity_id": _id, 
        }

    def get(self, key):
        key = str(key)
        r = requests.get(f"https://api.mama.sh/commodity/{key}")
        try:
            return json.dumps(json.loads(r.text), indent=4)
        except:
            return r.text
    def list(self):
        r = requests.get("https://api.mama.sh/commodity")
        try:
            return json.dumps(json.loads(r.text), indent=4)
        except:
            return r.text
    def create(self, obj):
        r = requests.post("https://api.mama.sh/commodity", json=obj)
        try:
            return json.dumps(json.loads(r.text), indent=4)
        except:
            return r.text
    def update(self, obj):
        r = requests.put("https://api.mama.sh/commodity", json=obj)
        try:
            return json.dumps(json.loads(r.text), indent=4)
        except:
            return r.text
