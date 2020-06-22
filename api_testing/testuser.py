import json
from API.user               import User
from random import randint

endcpr = str(randint(1000,9999))

print('TESTING USER STARTED')

print('LIST test started!')
com_test    = User()
_list       = json.loads(com_test.list())
print(json.dumps(_list, indent=4))
print('LIST test complete!')

print('GET test started!')
max_id      = max([x['userID'] for x in _list])
obj         = com_test.get(max_id)
print(obj)
print('GET test complete!')

print('CREATE test started!')
com_test.setJson(max_id + 1, "Tester", "Morten", "110292"+endcpr, "TM", [1,2], 0)
print(com_test.create(com_test.json))
print('CREATE test complete')

print('UPDATE test started!')
com_test.setJson(max_id + 1, "Tester", "Morten", "110292"+endcpr, "TM", [3,4], 1)
print(com_test.update(com_test.json))
print('UPDATE test complete')

print('DELETE test started!')
print(com_test.delete(43))
print('UPDATE test complete')

print('TESTING USER COMPLETE')
