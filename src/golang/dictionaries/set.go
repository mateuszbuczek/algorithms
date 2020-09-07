package main

type set struct {
	m map[string]bool
}

func NewSet() *set {
	s := &set{}
	s.m = make(map[string]bool)
	return s
}

func (s *set) Add(value string) {
	s.m[value] = true
}

func (s *set) Remove(value string) {
	s.m[value] = false
}

func (s *set) Contains(value string) bool {
	return s.m[value]
}

func (s *set) ToArray() *[]string {
	var result []string
	for k, v := range s.m {
		if v {
			result = append(result, k)
		}
	}

	return &result
}
